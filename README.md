
#### To use the PasswordValidator do the following

cd into pw-validation

run:
```
mvn package
mvn install
```
Include in your project's pom:

```
  <dependency>
       <groupId>pwvalidator</groupId>
       <artifactId>pwvalidator</artifactId>
       <version>0.0.1-SNAPSHOT</version>
  </dependency>
```
Create a bean to validate passwords against
```
<bean id="passwordValidator" class="pwvalidation.PasswordValidator"/>
```
Validate a password with the bean's 'validate' method.

Custom Validation: define a rule using the ValidationRule class in your config 
```
	<bean id="atLeastOneLowerCase" class="pwvalidation.ValidationRule">
		<property name="regex" value=".*[a-z].*"/>
	</bean>
		
	<bean id="passwordValidator" class="pwvalidation.PasswordValidator">
		<property name="rules">
			<list>
				<ref bean="atLeastOneLowerCase" />             
			</list>
		</property>
	</bean> 
```