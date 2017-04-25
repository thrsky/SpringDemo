#SpringBoot

>* Springboot的启动方式：    

     1. 通过idea启动      
     2. 在项目的根目录中，用mvn springboot:run启动
     3. 在项目的根目录中，mvn install -> java -jar target/***.jar启动
     
     第三种方式可以加参数：  
     比如在本实验中：     
     Java -jar target girl-0.0.1-SNAPSHOT.jar --spring.properties.active=dev(prod)
     

>* springboot的配置文件建议使用yml文件格式

>* 怎么在一个项目中同时使用多种配置文件，可以一种用idea启动，一种用mvn编译后jar方式启动

>* 基本注解：  
   @Controller ：处理http请求
   @RestController ： 是一个组合注解：原来返回Json需要@ResponseBody配合@Controller
   @RequestMapping ： 配置URL映射
   @PathVariable ： 获取URL中的数据
   @RequestParam ： 获取请求参数的值   
   @GetMapping ： 组合注解
  
>* 方法中参数过多：  
   可以直接把方法中的属性改为对象，URL中传入的方式不用变
   
   
>* 用Result<T> 来返回请求URL的返回对象   
   这样一来格式更加的规整   
   
>* 写一个类来专门捕获异常

>* 只要看到有重复的代码，首先要考虑能不能把代码合并，即定义一个新的处理类来完成这部分重复代码

>* mvn clean package
   会自动进行所有的测试用例