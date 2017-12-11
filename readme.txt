kWelcome to the Camel Exercises
==============================

Except the camel-exercises-features all the of the exercises can be started / deployment three way:

1) Deploy them inside an embedded Camel. In order to do that go to the root directory of the exercise like
   'camel-exercises-cbr' inside a Command Line Console and enter:

   mvn clean camel:run

NOTE:
    The 'clean' is not always necessary but it prevents the environment to carry over little changes from a
    previous run.

2) Deploy them as an OSGi bundle inside Servidemix 4. In order to do that you need to do the following:

- Go to the root directory of the exercise like 'camel-exercises-cbr'

- Build and Install the project using:

    mvn clean install

- Deploy them inside the Servicemix Karaf console using this:

    osgi:install -s mvn:com.fusesource.training/camel-exercises-cbr/2010.07.12

NOTE:
    Adjust the project name (here it is 'camel-exercises-cbr') according to the project you want to deploy

NOTE:
    You can built all the project in one swoop by going to the root directory of all exercises 'camel-exercises'
    and build and install them using:

    mvn clean install

3) Install the Exercise as Servicemix Feature by performing these steps:

- Go to the root directory of the camel exercises 'camel-exercises'

- Build and Install all exercises:

    mvn clean install

- Start Servicemix 4 and enter this into the Karaf console:

    features:addUrl mvn:com.fusesource.training/camel-exercises-features/2010.07.12/xml/features

- Install the desired Exercise:

    features:install camel-exercises-cbr

NOTE:
    Adjust the name of the exercise (here it is 'camel-exercises-cbr') according to the desired exercise.

NOTE:
    Further information and the latest changes can be found inside the exercise's readme.txt file.

ATTENTION:

    Running the Camel routes within an embedded Camel instance you don't need to copy any files but can
    just sit back and watch because Maven is copying the files into the right place.

    That said for the other deployments this is not going to happen. That said for most exercises the Camel
    route will create a directory under '/camel-exercises/' and you need to copy files into the 'in' directory
    by hand. There are some test files available in each exercise project under 'src/test/resources/camel/in'.