/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cronjobtest;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author j.anaya.villagrana
 */
public class HelloJob implements Job{
    public void execute(JobExecutionContext context) throws JobExecutionException{
        System.out.println("hello world!");
    }
}
