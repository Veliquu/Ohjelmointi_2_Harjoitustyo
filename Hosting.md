### Raspberry Pi
Asensin pöytäkoneelle ensin [Raspberry pi Imager](https://www.raspberrypi.com/software/). Käytin tätä asentaakseni Raspberry Pi Os micro sd kortille.

Rataspyörää painamalla pääsin asettamaaan ssh yhteyttä varten käyttäjän ja salasanan.  

Tein routerin asetuksissa port forwarding portteihin 80 ja 8888 ja sieltä sain myös tietoon Raspberry Pi:n ip-osoitteen.  
Tämän jälkeen otin ssh yhteyden Rasperry Pi:
```bash
~$ ssh jessepi@ip-osoite -p 8888
jessepi@raspberrypi:~ $ 
```

---
### Apache Tomcat
Asnesin Raspberry Pi:lle Java Development Kitin
```bash
jessepi@raspberrypi:~$ sudo apt install default-jdk

jessepi@raspberrypi:~$ java -version
openjdk version "11.0.16" 2022-07-19
OpenJDK Runtime Environment (build 11.0.16+8-post-Debian-1deb11u1)
OpenJDK 64-Bit Server VM (build 11.0.16+8-post-Debian-1deb11u1, mixed mode)
```
Tämän jälkeen asennetiin Apache Tomcat
```bash
jessepi@raspberrypi:~$ sudo apt indtall tomcat9
```
Laitoin verkkoselaimelle Raspberry Pin ip-osoitteen kokeillakseni onko Tomcat toiminnassa.  

---
### MariaDB
Asensin MAriaDBn
```bash
jessepi@raspberrypi:~$ sudo apt install mariadb
```
Tarkistin MariaDbn statuksen
```bash
jessepi@raspberrypi:~$ sudo systemctl status mariadb.service 
● mariadb.service - MariaDB 10.5.15 database server
     Loaded: loaded (/lib/systemd/system/mariadb.service; enabled; vendor preset: enabled)
     Active: active (running) since Mon 2022-12-12 06:09:03 EET; 1 day 8h ago
       Docs: man:mariadbd(8)
             https://mariadb.com/kb/en/library/systemd/
    Process: 16333 ExecStartPre=/usr/bin/install -m 755 -o mysql -g root -d /var/run/mysqld (code=exited, status=0/S>
    Process: 16334 ExecStartPre=/bin/sh -c systemctl unset-environment _WSREP_START_POSITION (code=exited, status=0/>
    Process: 16336 ExecStartPre=/bin/sh -c [ ! -e /usr/bin/galera_recovery ] && VAR= ||   VAR=`cd /usr/bin/..; /usr/>
    Process: 16400 ExecStartPost=/bin/sh -c systemctl unset-environment _WSREP_START_POSITION (code=exited, status=0>
    Process: 16402 ExecStartPost=/etc/mysql/debian-start (code=exited, status=0/SUCCESS)
   Main PID: 16383 (mariadbd)
     Status: "Taking your SQL requests now..."
      Tasks: 8 (limit: 8986)
        CPU: 35.838s
     CGroup: /system.slice/mariadb.service
             └─16383 /usr/sbin/mariadbd

Dec 12 06:09:03 raspberrypi mariadbd[16383]: 2022-12-12  6:09:03 0 [Note] /usr/sbin/mariadbd: ready for connections.
Dec 12 06:09:03 raspberrypi mariadbd[16383]: Version: '10.5.15-MariaDB-0+deb11u1'  socket: '/run/mysqld/mysqld.sock'>
Dec 12 06:09:03 raspberrypi systemd[1]: Started MariaDB 10.5.15 database server.
Dec 12 06:09:03 raspberrypi /etc/mysql/debian-start[16407]: Looking for 'mysql' as: /usr/bin/mysql
Dec 12 06:09:03 raspberrypi /etc/mysql/debian-start[16407]: Looking for 'mysqlcheck' as: /usr/bin/mysqlcheck
Dec 12 06:09:03 raspberrypi /etc/mysql/debian-start[16407]: This installation of MariaDB is already upgraded to 10.5>
Dec 12 06:09:03 raspberrypi /etc/mysql/debian-start[16407]: There is no need to run mysql_upgrade again for 10.5.15->
Dec 12 06:09:03 raspberrypi /etc/mysql/debian-start[16407]: You can use --force if you still want to run mysql_upgra>
Dec 12 06:09:03 raspberrypi /etc/mysql/debian-start[16415]: Checking for insecure root accounts.
Dec 12 06:09:03 raspberrypi /etc/mysql/debian-start[16419]: Triggering myisam-recover for all MyISAM tables and aria>
```
Tämän jällkeen otin MariaDBn käyttöön
```bash
jessepi@raspberrypi:~$ sudo systemctl enable mariadb.service 
Synchronizing state of mariadb.service with SysV service script with /lib/systemd/systemd-sysv-install.
Executing: /lib/systemd/systemd-sysv-install enable mariadb
```
Tämän jälkeen siirryin MariaDbhen
```bash
jessepi@raspberrypi:~$ sudo mariadb
Welcome to the MariaDB monitor.  Commands end with ; or \g.
Your MariaDB connection id is 32
Server version: 10.5.15-MariaDB-0+deb11u1 Debian 11

Copyright (c) 2000, 2018, Oracle, MariaDB Corporation Ab and others.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

MariaDB [(none)]> 
```
Ensimmäisenä loin käyttäjän
```bash
MariaDB [(none)]> CREATE USER testi@localhost IDENTIFIED BY 'password';
Query OK, 0 rows affected (0.005 sec)
``` 
Käyttäjälle annettiin kaikki oikeudet 
```bash
MariaDB [(none)]> GRANT ALL PRIVILEGES ON *.* TO testi@localhost IDENTIFIED BY 'password';
Query OK, 0 rows affected (0.004 sec)
```
Seuraavaksi loin tietokannan.
```bash
CREATE DATABASE Tulokset;
Query OK, 1 row affected (0.001 sec)
```
Otin tietokannan käyttöön ja loin sinne tablen
```bash
MariaDB [(none)]> USE Tulokset;
Database changed

MariaDB [Tulokset]> CREATE TABLE tulos(
    -> id INTEGER NOT NULL AUTO_INCREMENT,
    -> paiva date,
    -> rata varchar(20) not null,
    -> tuuli varchar(10) not null,
    -> tulos integer not null,
    -> PRIMARY KEY(id)
    -> );
Query OK, 0 rows affected (0.023 sec)
```
---
### Maven to War
Tomcat vaatii war tiedoston, jota en 


---
### Lähteet  
[GeekTechStuff](https://geektechstuff.com/2019/05/26/installing-apache-tomcat-jenkins-raspberry-pi/)  
[PhoenixNAP](https://phoenixnap.com/kb/how-to-create-mariadb-user-grant-privileges)  
