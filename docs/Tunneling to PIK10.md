# Working with our virtual machine

Quick tutorial how to connect to our VM.

## Introduction

Our VM's address is `pik10.ii.pw.edu.pl`, but unfortunatelly we cannot connect directly to it from the internet. 
To connect we will be using ssh tunneling through `galera.ii.pw.edu.pl` server.

## Connection

To connect please follow the steps:
1. Create ssh tunnel through `galera.ii.pw.edu.pl`
2. Connect to VM 
3. Disconnect from VM
4. Close ssh tunnel

## Creating ssh tunnel

To create a ssh tunnel we just run a once bash command:
```
ssh -L <local_port>:pik10:<remote_port> <user_name>@galera.ii.pw.edu.pl
```

- `<local_port>` - port on localhost to which we must connect in order to connect to VM thorugh tunnel;
- `<remote_port>` - port of `pik10` machine to which we will connect;
- `<user_name>` - your username from ELKA servers.

## Connecting to PIK10 via tunnel

After having created tunnel you should 'try to connect to localhost's `<local_port>`', the connection will be redirecrted to `pik10` machine.

## Example of usage

```
ssh -L 8022:pik10:22 pzelazko@galera.ii.pw.edu.pl
```
and then in another session
```
ssh pzelazko@localhost -p 8022
```

## Login using private key

It is possible to add our public key to a list of authorized keys either on `galera` server or on `pik10` machine.
<br />
In order to set it up please visit [this link](https://askubuntu.com/questions/46930/how-can-i-set-up-password-less-ssh-login)
