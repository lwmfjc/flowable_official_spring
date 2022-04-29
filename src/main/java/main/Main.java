package main;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngines;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;

public class Main {
    public static void main(String[] args) {
        /*ApplicationContext context
                = new AnnotationConfigApplicationContext(ConfigLy.class);
        Student bean = context.getBean(Student.class);
        System.out.println(bean.getAge());*/
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //部署流程
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("holiday-request.bpmn20.xml")
                .deploy();
        //打印部署id
        System.out.println("Found deployment id : " + deployment.getId());
        //查询引擎是否已经知道流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deployment.getId())
                .singleResult();
        System.out.println("Found process definition : " + processDefinition.getName());

    }
}
