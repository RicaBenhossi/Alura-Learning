#! /bin/bash

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
git checkout -b $course_branch_name $base_branch_name

echo
echo "------------------------------------------------------------"
echo
echo "Importing container files from branch $container_branch_name (merging)"
mkdir -p $course_folder_name/$course_branch_name
cd $course_folder_name/$course_branch_name
git merge container_branch_name

echo
echo "------------------------------------------------------------"
echo "|                 PROCESS FINISHED. ENJOY!                 |"
echo "------------------------------------------------------------"

