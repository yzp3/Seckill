package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    @Resource
    private SeckillDao seckillDao;


    /**
     * 1000元秒杀Iphone6
     * Seckill{
     * seckillId=1000, name='1000元秒杀Iphone6', number=100,
     * startTime=Thu Jan 11 00:00:00 CST 2018,
     * endTime=Fri Jan 12 00:00:00 CST 2018,
     * createTime=Fri Jan 11 21:26:41 CST 2019}
     * @throws Exception
     */
    @Test
    public  void testQueryById()throws Exception{
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }
    @Test
    public  void testQueryAll()throws Exception{
        List<Seckill> seckills = seckillDao.queryAll(0, 100);
        for (Seckill seckill : seckills){
            System.out.println(seckill);
        }
    } @Test
    public  void testReduceNumber()throws Exception{
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(1001L, killTime);
        System.out.println("updateCount="+updateCount);

    }
}