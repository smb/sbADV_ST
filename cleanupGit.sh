#!/bin/sh.exe

git filter-branch --commit-filter '
        if [ "$GIT_COMMITTER_NAME" = "Steffen Buehl" ];
        then
                GIT_COMMITTER_NAME="Steffen Buehl";
                GIT_AUTHOR_NAME="Steffen Buehl";
                GIT_COMMITTER_EMAIL="sb@sbuehl.com";
                GIT_AUTHOR_EMAIL="sb@sbuehl.com";
                git commit-tree "$@";
        else
                git commit-tree "$@";
        fi' HEAD
