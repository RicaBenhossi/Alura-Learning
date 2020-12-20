# Alura-Learning

This repo contains all the notes, codes and exercises of my Alura Courses

Every course has a specific branch. You have to switch to the branch of the course you want to see.

Every course branch has 2 basic branches:
1. language_base
  - that is created based on **master**
  - the name should follow the deault languagename_base
2. course branch
 - the criation of these branch will be done running the file "new_corse_branch.sh"

## Creating a new Course branch

1. Go to branch named **master**
2. Add the new course branch name to README.md file on section BRANCH LIST.
3. Commit these changes on this branch.
4. Create a new branch based on **master**. This branch will be the base of the new course branch.
  - The name of this branch should follow the pattern language-name_base (e.g: python_base)
  Every change on readme or gitignore files must be done on branch **master**. After commit it, it must be merged to the project/course branch
5. Create a default folder in the course branch base using the main language name of the course.
  - if you'll use a docker container to run vscode, the .devcontainer folder should be add inside this folder.
  **Every language course should, if possible, have it's own container (one container per language).**
6. Go to back to branch **master**
7. Execute the file "new_corse_branch.sh" on terminal and follow it's instructions.
8. You're done...

- **Every change on dockerfile or devcontainer.json should be done on branch named language-name_base of the project/language.**
  - After the changes being commited, you must merge it into the course/project branch you are wirking (or the other ones you want).

The folder structure will be as the following exemple:

- Python courses

python (folder)
  |-- .devcontainer (if it runs inside a docker container)
  |-- 01-course (folder)
        |-- .vscode (folder)
              |-- tasks.json
        | Files/Folders of the course.
  |-- 02-course
## Branch List

### JAVA

- java_base
- 01-Java_JRE_JDK
- 02-Java_OO
- 11-DataStructure_Java
- 12-JavaJPA_Part01
- 13-JavaJpa_part02

### PYTHON

- python_base
- 01-DataStructure_Python

### Git and GitHub

- 01-Git_GitHub