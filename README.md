# About

Use this package as base to develop a [kdcloud](http:///github.com/vispax/kd-cloud) plugin.

# How To

Before you need to include the required libraries, which can be found in the `lib` folder.
+ If you are using maven you need to install them in your local repository:

	mvn install:install-file -Dfile=lib/kdcloud-engine-0.0.1-SNAPSHOT.jar \
		-DgroupId=com.kdcloud -DartifactId=kdcloud-engine -Dversion=0.2-SNAPSHOT
	mvn install:install-file -Dfile=lib/weka-stripped-3.7.7-SNAPSHOT.jar \
		-DgroupId=com.kdcloud -DartifactId=weka-stripped -Dversion=3.7.7-SNAPSHOT

+ If you are using Eclipse instead, create a project and include them in the build path, along with the JUnit4 library

Under `src/main/java` you will find the `NoneStub` which can be used to develop your own node. Of course you can create any other class and package you need. You should name your node but you cannot use another package for it.

When you are done you must test the node. Place a CSV file with data suitable for testing under `src/test/resources`, then edit the file `test-case.xml` in the same directory specifing the name of the CSV file and the name of your node.
+ With maven you can test the module running `mvn test`
+ With Eclipse select the class under `src/test/java`, right click>Run As>JUnit Test

If the test runs without errors you can build the jar.
+ With maven just run `mvn package`
+ With Eclipse select the folders under `src/main` and export them as jar file
