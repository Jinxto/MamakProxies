### README.md

---

# Discord Bot Deployment Guide

This guide will walk you through deploying your Discord bot, which uses the Shopify API to sell and generate residential proxies, to a Linux AWS server.

## Overview

This guide covers the following steps:

1. Prerequisites
2. Launching an EC2 Instance
3. Connecting to Your EC2 Instance
4. Installing Java, Git, and Maven
5. Cloning Your Repository
6. Setting Up Environment Variables
7. Building and Running Your Bot
8. Verifying Your Bot is Running
9. Running Your Bot in the Background
10. Conclusion

## Table of Contents

- [Prerequisites](#prerequisites)
- [Step 1: Launch an EC2 Instance](#step-1-launch-an-ec2-instance)
- [Step 2: Connect to Your EC2 Instance](#step-2-connect-to-your-ec2-instance)
- [Step 3: Install Java, Git, and Maven](#step-3-install-java-git-and-maven)
- [Step 4: Clone Your Repository](#step-4-clone-your-repository)
- [Step 5: Set Up Environment Variables](#step-5-set-up-environment-variables)
- [Step 6: Build and Run Your Bot](#step-6-build-and-run-your-bot)
- [Step 7: Verify Your Bot is Running](#step-7-verify-your-bot-is-running)
- [Step 8: Run Your Bot in the Background](#step-8-run-your-bot-in-the-background)
  - [Using `tmux`](#using-tmux)
  - [Using `screen`](#using-screen)
  - [Using `nohup`](#using-nohup)
- [Conclusion](#conclusion)

## Prerequisites

Before you begin, ensure you have the following:

1. **AWS Account**: Set up and configured.
2. **AWS EC2 Instance**: A running instance with SSH access.
3. **Java**: Installed on your EC2 instance.
4. **Git**: Installed on your EC2 instance.
5. **Maven**: Installed on your EC2 instance.
6. **Environment Variable**: Set up for your Discord bot token.

## Step 1: Launch an EC2 Instance

1. Log in to your AWS Management Console.
2. Navigate to the EC2 Dashboard and launch a new instance.
3. Choose an Amazon Machine Image (AMI), such as Amazon Linux 2.
4. Select an instance type (e.g., t2.micro).
5. Configure instance details, add storage, and configure security groups to allow SSH (port 22) and other necessary ports.
6. Review and launch the instance. Ensure you have a key pair (.pem file) for SSH access.

## Step 2: Connect to Your EC2 Instance

Use SSH to connect to your instance. Replace `YOUR_KEY_PAIR.pem` and `YOUR_INSTANCE_PUBLIC_DNS` with your key pair file and instance DNS.

```sh
ssh -i "YOUR_KEY_PAIR.pem" ec2-user@YOUR_INSTANCE_PUBLIC_DNS
```

## Step 3: Install Java, Git, and Maven

Update the package repository and install Java, Git, and Maven:

```sh
sudo yum update -y
sudo yum install java-1.8.0-openjdk-devel -y
sudo yum install git -y
sudo yum install maven -y
```

## Step 4: Clone Your Repository

Clone your Discord bot repository from GitHub:

```sh
git clone https://github.com/yourusername/your-repo-name.git
cd your-repo-name
```

## Step 5: Set Up Environment Variables

Set your Discord bot token as an environment variable. Replace `YOUR_DISCORD_BOT_TOKEN` with your actual bot token.

```sh
echo 'export DISCORD_BOT_TOKEN="YOUR_DISCORD_BOT_TOKEN"' >> ~/.bash_profile
source ~/.bash_profile
```

## Step 6: Build and Run Your Bot

Compile and run your Discord bot using Maven:

```sh
mvn clean package
java -jar target/your-bot.jar
```

Replace `your-bot.jar` with the actual name of the JAR file generated in the `target` directory.

## Step 7: Verify Your Bot is Running

Check the logs to ensure your bot is running correctly and connected to Discord.

## Step 8: Run Your Bot in the Background

To keep your bot running even after you log out of the SSH session, use a tool like `tmux`, `screen`, or `nohup`.

### Using `tmux`

```sh
sudo yum install tmux -y
tmux
java -jar target/your-bot.jar
# To detach from the tmux session, press Ctrl+B, then D.
```

### Using `screen`

```sh
sudo yum install screen -y
screen -S discord-bot
java -jar target/your-bot.jar
# To detach from the screen session, press Ctrl+A, then D.
```

### Using `nohup`

```sh
nohup java -jar target/your-bot.jar &
```

## Conclusion

Your Discord bot should now be running on your AWS EC2 instance. You can monitor its activity through the Discord developer portal and manage your AWS instance as needed. For further enhancements, consider setting up a CI/CD pipeline to automate deployment.

---

Remember to replace placeholders such as `YOUR_KEY_PAIR.pem`, `YOUR_INSTANCE_PUBLIC_DNS`, `yourusername/your-repo-name`, `YOUR_DISCORD_BOT_TOKEN`, and `your-bot.jar` with your actual values.
