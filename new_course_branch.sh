#! /bin/bash

execute_command(){
    command_to_execute=$1
    $command_to_execute
    error=$?
    if [[ $error -ne 0 ]]; then
        echo
        echo "Command fail to execute! Fix it and try again."
        echo
        $SHELL
    fi
}

merge_new_branch_to_main (){
    while true
    do
        echo "$1"
        read -r -s -n 1 response
        case "$response" in
            [Yy]|[Nn])
                if [[ ($response == "Y") || ($response == "y") ]]; then
                    execute_command "git switch main"
                    read
                    execute_command "git pull origin"
                    read
                    execute_command "git merge $course_branch_name"
                    read
                    execute_command "git push origin"
                    read
                    execute_command "git switch $course_branch_name"
                fi
                break
            ;;
            *)
                echo "Invalid option."
            ;;
        esac
    done
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
execute_command "git checkout -b $course_branch_name $base_branch_name"

echo
echo "------------------------------------------------------------"
echo
echo "Importing container files from branch $container_branch_name (checkout)"
echo
if [[ -n "$container_branch_name" ]]; then
    execute_command "git checkout $container_branch_name .devcontainer/"
    execute_command "mkdir -p $course_main_folder_name/$course_branch_name"
    execute_command "mv .devcontainer $course_main_folder_name/$course_branch_name"
    execute_command "git add ."
fi

commit_message="Branch $course_branch_name created. Ready to use."
execute_command "git commit -m "$commit_message""

merge_new_branch_to_main "Would you like to merge this new branch to main? [Y/N]"

execute_command "cd $course_main_folder_name/$course_branch_name"
execute_command "git push --set-upstream origin "$course_branch_name""
echo
echo "** Branch $course_branch_name created and sent to github. **"
echo
echo "------------------------------------------------------------"
echo "|                 PROCESS FINISHED. ENJOY!                 |"
echo "------------------------------------------------------------"