# runemate-bot-template

## About

The purpose for this repository is to simplify/bootstrap [RuneMate](https://www.runemate.com/) bot projects on Linux.

This development workspace is for IntelliJ IDEA workspaces specifically.

Note that RuneMate workspaces aren't configured to run your code directly.
They're configured to launch the dependency [`RuneMate.jar`](lib/RuneMate.jar) in development mode
which will then look for the bots in a specific directory on your computer. 

This project is based on a guide found on the RuneMate forum, [here](https://www.runemate.com/community/threads/the-coding-chronicles-chapter-two-hello-world.6738/).

## Setup

### Ubuntu

#### Setup Java environment
```bash
# You'll need Java 1.8 (nothing higher):
sudo apt-get install openjdk-8-jre
# RuneMate bots use JavaFX:
sudo apt-get install openjfx
# Move the libraries:
sudo cp /usr/share/java/openjfx/jre/lib/ext/* /usr/lib/jvm/java-1.8.0-openjdk-amd64/lib
sudo cp /usr/share/java/openjfx/lib/* /usr/lib/jvm/java-1.8.0-openjdk-amd64/lib
sudo chmod 777 -R /usr/lib/jvm/java-1.8.0-openjdk-amd64
```

#### Configure IntelliJ IDE

- Navigate to File -> Project Structure -> Global Library
  - Add `/usr/share/java/openjfx` and `/usr/share/java/openjfx/lib`.
- Navigate to File -> Project Structure -> Libraries
  - Add `lib/RuneMate.jar`

I've provided a simple Run configuration in this template.
It's configured to launch the `RuneMate.jar` file with specific command-line arguments and RuneMate-specific classpath.
- Navigate to Run -> Edit Configuration -> Templates -> Application
  - "Main Class": com.runemate.Boot
  - "Program Arguments": -sdk -login="runemateuser":"runematepassword"

Finally, to follow both author convention,
you'll want to go through the project and rename/correct usages of "runemateuser" to your own RuneMate account username.
The only locations should be:
- [`src.com.runemateuser`](src/com/runemateuser/)
  - Rename this file to your username
- [`src.com.runemateuser.bots.tutorial_bot.TutorialBot`](src/com/runemateuser/bots/tutorial_bot/TutorialBot.java)
  - Fix the import to use your username
- [`src.com.runemateuser.bots.tutorial_bot.TutorialBot.manifest.xml`](src/com/runemateuser/bots/tutorial_bot/TutorialBot.manifest.xml)
  - Correct `<main-class>` tag to use the new path.

#### Configure RuneMate

Launch RuneMate by navigating to Run -> Run 'Boot, 
then go to the Settings page on RuneMate and update the path to this template project's path.
 
Once you have RuneMate launched, you'll need to ensure it can actually find the code in this repository.

#### Writing Bots

All bots should go under: [`src/com/runemateuser/bots/`](src/com/runemateuser/bots/) to be picked up by RuneMate.

#### Setup OldSchool RuneScape:

```bash
mkdir -p '/tmp/oldschool'
wget -O '/tmp/oldschool/OldSchool.msi' 'http://www.runescape.com/downloads/oldschool.msi'
cd /tmp/oldschool && msiextract OldSchool.msi
cp /tmp/oldschool/jagexlauncher/jagexlauncher/bin/jagexappletviewer.jar /usr/local/bin/jagexappletviewer.jar
cp /tmp/oldschool/jagexlauncher/jagexlauncher/oldschool/jagexappletviewer.png /usr/local/share/jagexappletviewer.png
chmod 755 /usr/local/bin/jagexappletviewer.jar
rm -rf /tmp/oldschool
echo "/usr/local/bin/jre/bin/java -Duser.home=$HOME -Djava.class.path=/usr/local/bin/jagexappletviewer.jar -Dcom.jagex.config=http://oldschool.runescape.com/jav_config.ws jagexappletviewer /usr/local/share/" >> /usr/local/bin/oldschool
chmod +x /usr/local/bin/oldschool
```

### Windows

(TODO)