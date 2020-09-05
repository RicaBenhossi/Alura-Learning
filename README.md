# Alura-Learning

This repo contains all the notes, codes and exercises of my ALura Courses

Every course has a specific branch. You have to checkout to the branch of the course you want to see.
Every change on dockerfile or devcontainer.json should be done on branch Container and MERGED to the other branches.

## Creating a new Course branch

1. Create a new branch with the course name (see Branch list to follow the pattern) from branch_base branch.
2. Checkout to the new branch
3. Merge the branch Container into it to add the .devcontainer folder
4. Add the task.json of vscode to autoamtically switch to the right branch on opening folder
5. Commit and push these changes.
6. Merge these changes to branch master.
7. Checkout to the course branch and you're done.

## Branch List

### JAVA

- Container
- 01-JavaPart01
- 02-03-JavaPart02-03-Heranca_Interfaces
- 04-JavaPart04-Exceptions
- 05-JavaPart05-Packages
- 06-JavaPart06-Java.Utils
- 07-JavaPart07.IO
- 08-Collections
- 09-JavaMaven
- 10-JavaServletsPart01
- 11-JavaServletsPart02
- 12-JavaJPA_Part01
