
flush() is for making writing into files permanently (similar to saving it)

For Java IO decorator, have to close all the streams in LIFO order

catch block not required when method can "throws exception"

finally block usually used for cleaning up (flush/close)

javac ./*.java people/*.java service/*.java -d target
java -cp target App "data" "person.csv"
Go to target folder:
jar -c -v -f day03.jar -e App .
Go to root folder
java -jar target/day03.jar "data" "person.csv"