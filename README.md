# Single-page

This is a simple single page application based on Dropwizard framework

### Installation

```sh
$ git clone [git-repo-url] single-page
$ cd single-page
$ gradle run - by default will be running data migration to h2 db
Open file - build.gradle
Comment string - args 'db', 'migrate', './single-page.yml'
Uncomment string - args 'server', './single-page.yml'
$ gradle run - application will be started
```

Open [application url](http://localhost:8080/single-page/app/views/index.html) in your browser
