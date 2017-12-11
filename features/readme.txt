This Exercise is here to make it easy to deploy all Exercises of this Training in one single
step deploying it as a feature.

Deployment:

In order to deploy it please go to the parent directory 'camel-exercises' and build ALL exercises using:

    mvn clean install

The start up Servicemix 4 and load the features list into Servicemix:

    features:addUrl mvn:com.fusesource.training/camel-exercises-features/2010.07.12/xml/features

verify this by checking the features list:

    features:list | grep camel-exercises

Note

    The grep command will remove all entries that does not contain the given text.

You will see a list like this:

---------------------------------------------------------------------------------
karaf@root> features:list | grep camel-exercises
[uninstalled] [0.0.0               ] camel-exercises-cbr                   repo-0
[uninstalled] [0.0.0               ] camel-exercises-ftp                   repo-0
[uninstalled] [0.0.0               ] camel-exercises-splitter              repo-0
[uninstalled] [0.0.0               ] camel-exercises-aggregator            repo-0
[uninstalled] [0.0.0               ] camel-exercises-jms-transaction       repo-0
[uninstalled] [0.0.0               ] camel-exercises-custom-file-component repo-0
---------------------------------------------------------------------------------

Now in order to deploy / install any of these components you simple do (here the CBR exercise is used to demo
it):

    features:install camel-exercises-cbr

Check your list again and you see:

[installed  ] [0.0.0               ] camel-exercises-cbr                   repo-0



