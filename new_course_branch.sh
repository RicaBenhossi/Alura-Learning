#! /bin/bash

execute_command(){
    command_to_execute=$1
    $command_to_execute
    sleep 1
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

branch_name_exist(){
    branch_name=$1

    branch_list="$(git branch --list)"
    if [[ "$branch_list" == *"$branch_name"* ]]; then
        return $(true)
    else
        return $(false)
    fi
}

create_branch_name(){
    while true
    do
        echo "What is the name of the course?" >&2
        read course_name
        echo >&2

        while true
        do
            echo "What is the order number of the course? (See the last course added in README file)" >&2
            read course_order
            echo >&2
            case $course_order in
                ''|*[!0-9]*)
                    echo >&2
                    echo "The input must be a nunber." >&2
                    echo >&2 ;;
                *) break ;;
            esac
        done

        if ($(branch_name_exist $course_order-$course_name)); then
            echo >&2
            echo "================================================================================" >&2
            echo "Error" >&2
            echo >&2
            echo "      The branch name $branch_name already exist. Choose another name." >&2
            echo >&2
            echo "================================================================================" >&2
            echo >&2
            echo >&2
        else
            break
        fi
    done

    echo "$course_order-$course_name"
}

get_base_branch(){
    while true
    do
        echo "Here is the list of branches we have." >&2
        echo >&2
        echo "$(git branch --list)" >&2
        echo >&2
        echo "What is the branch you want to use as the base of this new branch?" >&2
        read container_branch_name
        echo >&2

        if (! $(branch_name_exist $container_branch_name)); then
            echo >&2
            echo "================================================================================" >&2
            echo "Error" >&2
            echo >&2
            echo "      The branch $container_branch_name doesn't exist. Choose another one." >&2
            echo >&2
            echo "================================================================================" >&2
            echo >&2
            echo >&2
        else
            break
        fi
    done
    echo $container_branch_name
}

merge_branch_base() {
    branch_base_name=$1
    default_base_branch="branch_base"
    echo "Merging $default_base_branch into $branch_base_name">&2
    echo >&2
    execute_command "git merge $default_base_branch $branch_base_name"
    echo >&2

}

create_new_branch(){
    echo >&2
    echo "------------------------------------------------------------" >&2
    echo >&2
    echo "Creating a new course branch based on $base_branch_name" >&2
    echo >&2
    course_branch=$1
    base_branch=$2
    merge_branch_base $base_branch
    echo >&2
    echo "Creating the new branch " >&2
    echo >&2
    execute_command "git checkout -b $course_branch $base_branch"
    echo >&2
    echo "** Branch $course_branch_name created. **" >&2
    echo >&2
}

create_tasks_json(){
    if (confirm_option_yn "Would you like to create standard tasks.json? [Y/N]") ; then
        branch_name=$1
        vscode_folder="$2$branch_name/.vscode"
        echo >&2
        echo "------------------------------------------------------------" >&2
        echo >&2
        echo "Creating .vscode/tasks.json file." >&2
        execute_command "mkdir -p $vscode_folder"
        echo '{' >> $vscode_folder/tasks.json
        echo '    // See https://go.microsoft.com/fwlink/?LinkId=733558' >> $vscode_folder/tasks.json
        echo '    // for the documentation about the tasks.json format' >> $vscode_folder/tasks.json
        echo '    "version": "2.0.0",' >> $vscode_folder/tasks.json
        echo '    "tasks": [' >> $vscode_folder/tasks.json
        echo '        {' >> $vscode_folder/tasks.json
        echo '            "label": "Checkout right branch",' >> $vscode_folder/tasks.json
        echo '            "type": "shell",' >> $vscode_folder/tasks.json
        echo '            "command": "git checkout '$branch_name'",' >> $vscode_folder/tasks.json
        echo '            "problemMatcher": [],' >> $vscode_folder/tasks.json
        echo '            "runOptions": {"runOn": "folderOpen"}' >> $vscode_folder/tasks.json
        echo '        }' >> $vscode_folder/tasks.json
        echo '    ]' >> $vscode_folder/tasks.json
        echo '}' >> $vscode_folder/tasks.json
        echo >&2
        echo "File tasks.json created." >&2
        echo >&2
        echo "Commiting task.json file creation." >&2
        echo >&2
        commit_branch "File .vscode/tasks.json created."
        echo >&2
        echo "** Tasks.json sucessfully created. **" >&2
        echo >&2
    fi
}

merge_new_branch_to_main(){
    branch_name=$1
    echo >&2
    echo "------------------------------------------------------------" >&2
    echo >&2
    if (confirm_option_yn "Would you like to merge this new branch to main? [Y/N]") ; then
        echo >&2
        execute_command "git checkout main"
        execute_command "git pull origin"
        execute_command "git merge $branch_name"
        execute_command "git push origin"
        execute_command "git checkout $branch_name"
        echo >&2
        echo "** Branch $branch_name sucessfully merges into branch main" >&2
        echo >&2
    fi
}

push_to_github(){
    branch_name-$1
    echo >&2
    echo "------------------------------------------------------------" >&2
    echo >&2
    echo "Pushing "$branch_name" to github" >&2
    echo >&2
    execute_command "git push --set-upstream origin "$branch_name""
    echo >&2
    echo "** Branch "$branch_name" sucessfully pushed to github. **" >&2
    echo >&2
}

echo "************************************************************"
echo "*                                                          *"
echo "*                 CREATE NEW COURSE BRANCH                 *"
echo "*                                                          *"
echo "************************************************************"
echo
echo

course_branch_name=$(create_branch_name)

base_branch_name=$(get_base_branch)

create_new_branch $course_branch_name $base_branch_name

course_main_folder_name=$(ls -d */)

create_tasks_json $course_branch_name $course_main_folder_name

push_to_github $course_branch_name

merge_new_branch_to_main $course_branch_name

execute_command "cd $course_main_folder_name$course_branch_name"

echo "------------------------------------------------------------"
echo "|                 PROCESS FINISHED. ENJOY!                 |"
echo "------------------------------------------------------------"