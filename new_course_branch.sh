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
read course_folder_name
echo

course_branch_name=$course_order-$course_name
base_branch_name="branch_base"
container_branch_name="Container"

echo
echo "------------------------------------------------------------"
echo
echo "Creating a new course branch based on $base_branch_name"
echo
execute_command "git checkout -b $course_branch_name $base_branch_name"

echo
echo "------------------------------------------------------------"
echo
echo "Importing container files from branch $container_branch_name (merging)"
echo
execute_command "mkdir -p $course_folder_name/$course_branch_name"
execute_command "cd $course_folder_name/$course_branch_name"
execute_command "git merge $container_branch_name"

echo
echo "------------------------------------------------------------"
echo "|                 PROCESS FINISHED. ENJOY!                 |"
echo "------------------------------------------------------------"

