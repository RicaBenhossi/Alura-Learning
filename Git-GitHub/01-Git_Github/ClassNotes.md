# Git and GitHub course notes

### How Git Works

Git controls all modificantions in the files of the repository, creating a history of changes that the files has passed by over the time.

Git has 3 basic stages:
  1. Working tree
    Here are the files you are editing and modifying at te moment.
  2. Stage
    Here are the files you finish modifying and are ready to be commited
  3. HEAD
    Here is the files you already commited.

Git workflow to consolidate your changes to HEAD, is:
  1. finish your changes and save the file.
  2. add the file(s) to stage area (git add)
  3. commit these changes (git commit)


### Conventions

- Commit
  - The commit should contains a small bunch of changes or a feature (or a significant part of it). So if you have big changes to make, split it in smalls changes
  - **Avoid commits with too much changes.** Split the changes into small changes when it is possible.
  - The commit message should be a short, but clear, message that shows what changes that commit contains.
  - When to commit your code?
    That depends on how each team works, but in general, we should follow some tips:
    - Commit your code when a bug is fixed. If it is a big fix, try to split it into small pack of changes to commit inparts (changes in one file, for exemple)
    - Commit it when you add a small new feature, or when a small part of a big new feture is done.
    - When our code is in a state that you would like to remember.
    - **You should not commit code that doesn't work**. Altought is not recommended to olnly commit in the endo of a feature/bug fix.

### General Commands

- git init
  This command initialize the current folder as a git repository to git start tracking it.

- git add
  This command add the files to the stage area. This area holds the files selected to be commited
  E.g.:
    - git add <file-name> -> add an specific file. You can put more files
    - git add . -> add all files in the current directory

- git commit
  This command consolidate your changes in a "package" and we used to put some short message.
  E.g.:
    - git commit -m 'Your message here'

- git status
  Show the status of the branch you are in.

- git log
  Shows you all the history that already occured in your repository. See http://devhints.io/git-log to have some tips and how to use it.

- .gitignore (file)
  You can make Git to ignore some file or folders. You just need to add a special file named .gitignore to your project.
  In these, file you just add the the files and folder (using / at the end) that you don't want git tracks.
  So now, if you type git status, git won't show you to commit the files or folders you setto ignore.
  Altough git won't track these files, it will show you to commit the .gitignore file.