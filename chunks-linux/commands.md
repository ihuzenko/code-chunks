Alright, time to finalize and structure all the useful commands.

#### Exploring System
Print current work dir.
```shell script
pwd
```
Change dir.
```shell script
cd /
cd $HOME
cd ~
cd /var/lib/
cd - 
cd ..
```

- cd 
- ls
- hostname
- uname
- whatis 
- see env variables
- see where binary is 
- see apps installed
- see version 
- see hardware info

#### Apt package manager
- apt

#### File and archive management
- touch 
- cat 
- head 
- tail 
- cp 
- mv 
- rm 
- comm 
- less 
- ln 
- cmp 
- dd 
- tar
- scp

#### Search and format text
How many times word found in the file.
```shell script
grep -c word file
```
Search pattern ignoring case. 
```shell script
grep -i pattern file
```
Count lines in a file.
```shell script
wc -l file
```
Count words in a file. 
```shell script
wc -w file
```

- awk

#### File access management 
- chmod
- chown
- chgrp 
- acl

#### User management

- who 
- whoami
- useradd
- userdel
- groupadd

#### Process management 
- ps 
- kill 
- service

#### Logs and history
- history

#### Getting help 
```shell script
man <command>
<command> --help
```

#### Networking 
- wget 
- curl 
- iptables 
- traceroute
