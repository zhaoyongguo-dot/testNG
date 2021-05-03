使用maven命令运行case:mvn -f pom.xml clean test  -DxmlFileName=testNG.xml
                    mvn test -Dtest=ImportAdministrativeDivisionTests#importProvinceData -DfailIfNoTests=false
                    mvn test -Dtest=类名#方法名 -DfailIfNoTests=false
3. 编译源代码:mvn compile
4. 编译测试代码:mvn test-compile
5. 编译并测试:mvn test
6. 产生site:mvn site
7. 清空生成的文件:mvn clean
8. 显示版本信息:mvn -version/-v

git push --all origin    是将本地的全部进行上推，不存在的就新建分支，囫囵吞枣的全部推上去，远程与本地就一致了！！！
git push --force origin  我们在推送的时候应该把本地也弄成最新的，fetch+merge下或者pull下就是最新的版本了。
                         我们相信本地的版本以本地的版本为准，把远程的进行覆盖，我们加上force即可，强制推送了！！！！！
git push origin :master  远程分支的删除 等同于git push origin --delete master

git push <远程主机名> <本地分支名>:<远程分支名> 我们一般会省略本地分支，因为我们就在本地分支呀~
git push origin master
git add -u <==> git add –update 提交所有被删除和修改的文件到数据暂存区
git add .                       提交所有修改的和新建的数据暂存区
git add -A <==>git add –all     提交所有被删除、被替换、被修改和新增的文件到数据暂存区



test注解
1.dependsOnMethods:依赖的方法
2.

invoked 调用
redundant 多余的
new 对象的时候自动补全:ctrl + alt + v
快速复制一行:ctrl + d
快速解决:alt + enter

TestNG的注解:
注解	            描述
@BeforeSuite	注解的方法将只运行一次，运行所有测试前此套件中。
@AfterSuite	    注解的方法将只运行一次此套件中的所有测试都运行之后。
@BeforeClass	注解的方法将只运行一次先行先试在当前类中的方法调用。
@AfterClass	    注解的方法将只运行一次后已经运行在当前类中的所有测试方法。
@BeforeTest	    注解的方法将被运行之前的任何测试方法属于内部类的 <test>标签的运行。
@AfterTest	    注解的方法将被运行后，所有的测试方法，属于内部类的<test>标签的运行。
@BeforeGroups	组的列表，这种配置方法将之前运行。此方法是保证在运行属于任何这些组第一个测试方法，该方法被调用。注解的方法将被运行在每个 <group>标签前
@AfterGroups	组的名单，这种配置方法后，将运行。此方法是保证运行后不久，最后的测试方法，该方法属于任何这些组被调用。注解的方法将被运行在每个 <group>标签后
@BeforeMethod	注解的方法将每个测试方法之前运行。
@AfterMethod	被注释的方法将被运行后，每个测试方法。
@DataProvider   标志着一个方法，提供数据的一个测试方法。注解的方法必须返回一个Object[] []，其中每个对象[]的测试方法的参数列表中可以分配。
                该@Test 方法，希望从这个DataProvider的接收数据，需要使用一个dataProvider名称等于这个注解的名字。
@Factory	    作为一个工厂，返回TestNG的测试类的对象将被用于标记的方法。该方法必须返回Object[]。
@Listeners	    定义一个测试类的监听器。
@Parameters	    介绍如何将参数传递给@Test方法。
@Test	        标记一个类或方法作为测试的一部分。