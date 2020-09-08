#! /bin/bash

execute_command(){
    command_to_execute=$1
    $command_to_execute
    error=$?
    if [[ $error -ne 0 ]]; then
        echo
        echo "Try to execute $command_to_execute"
        echo "Execution fail! Fix it and try again."
        echo
        $SHELL
    fi
}

confirm_option_yn(){
    warning_message=$1
    while true
    do
        echo "$warning_message" >&2
        read -r -s -n 1 response
        case "$response" in
            [Yy]|[Nn])
                if [[ ($response == "Y") || ($response == "y") ]]; then
                    return $(true)
                else
                    return $(false)
                fi
                break
            ;;
            *)
                echo "Invalid option." >&2
            ;;
        esac
    done
}

commit_branch(){
    message=$1
    execute_command "git add ."
    execute_command "git commit -m "$message""
}

create_new_branch(){
    course_branch=$1
    base_branch=$2
    course_folder=$3
    execute_command "git checkout -b $course_branch $base_branch"
    execute_command "mkdir -p $course_folder/$course_branch"
}

create_tasks_json(){
    branch_name=$1

    if (confirm_option_yn "Would you like to create standard tasks.json? [Y/N]") ; then

        echo
        echo "------------------------------------------------------------"
        echo
        echo "Creating .vscode/tasks.json file."
        execute_command "mkdir .vscode/"
        echo '{' >> .vscode/tasks.json
        echo '    // See https://go.microsoft.com/fwlink/?LinkId=733558' >> .vscode/tasks.json
        echo '    // for the documentation about the tasks.json format' >> .vscode/tasks.json
        echo '    "version": "2.0.0",' >> .vscode/tasks.json
        echo '    "tasks": [' >> .vscode/tasks.json
        echo '        {' >> .vscode/tasks.json
        echo '            "label": "Checkout right branch",' >> .vscode/tasks.json
        echo '            "type": "shell",' >> .vscode/tasks.json
        echo '            "command": "git checkout '$branch_name'",' >> .vscode/tasks.json
        echo '            "problemMatcher": [],' >> .vscode/tasks.json
        echo '            "runOptions": {"runOn": "folderOpen"}' >> .vscode/tasks.json
        echo '        }' >> .vscode/tasks.json
        echo '    ]' >> .vscode/tasks.json
        echo '}' >> .vscode/tasks.json
        echo
        echo "File tasks.json created."
        echo
        echo "Commiting task.json file creation."
        echo
        commit_branch "File .vscode/tasks.json created."
    fi
}

import_container_files()
{
    container_branch=$1
    if [[ -n "$container_branch" ]]; then
        course_folder=$2
        course_branch=$3

        echo "------------------------------------------------------------"
        echo
        echo "Importing container files from branch $container_branch (checkout)"
        echo

        execute_command "git checkout $container_branch .devcontainer/"
        execute_command "mv .devcontainer $course_folder/$course_branch"
        echo
        echo "Commiting adition of container files."
        echo
        commit_branch "Container files created."
    fi

}

merge_new_branch_to_main (){
    branch_name=$1
    echo
    echo
    if (confirm_option_yn "Would you like to merge this new branch to main? [Y/N]") ; then
        execute_command "git switch main"
        execute_command "git pull origin"
        execute_command "git merge $branch_name"
        execute_command "git push origin"
        execute_command "git switch $branch_name"
    fi
}


echo "************************************************************"
echo "*                                                          *"
echo "*                 CREATE NEW COURSE BRANCH                 *"
echo "*                                                          *"
echo "************************************************************"
echo
echo

echo "What is the name of the course?"
read course_name
echo

echo "What is the order number of the course? (See the last course added in README file)"
read course_order
echo

echo "What is the main folder or language folder of the course? (E.g.: Java/course or Python/course)"
read course_main_folder_name
echo

echo "What is the branch of container (E.g.: ContainerJava)? Leave it blank if there is not a container."
read container_branch_name
echo

course_branch_name=$course_order-$course_name
base_branch_name="branch_base"

echo
echo "------------------------------------------------------------"
echo
echo "Creating a new course branch based on $base_branch_name"
echo

create_new_branch $course_branch_name $base_branch_name $course_main_folder_name

echo
echo "** Branch $course_branch_name created.*"
echo

create_tasks_json $course_branch_name

import_container_files $container_branch_name $course_main_folder_name $course_branch_name

execute_command "git push --set-upstream origin "$course_branch_name""
echo
echo "Branch "$course_branch_name" pushed to github."
echo

merge_new_branch_to_main $course_branch_name

execute_command "cd $course_main_folder_name/$course_branch_name"

echo "------------------------------------------------------------"
echo "|                 PROCESS FINISHED. ENJOY!                 |"
echo "------------------------------------------------------------"