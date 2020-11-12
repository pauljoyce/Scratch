package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * @Author: mengchao
 * @Date: 2020/11/12 17:04
 */
@Aspect
@Component
public class MyLogAspect implements Ordered {
    public static Logger log = Logger.getLogger("MyLogAspect.class");
    // 2. PointCut表示这是一个切点，@annotation表示这个切点切到一个注解上，后面带该注解的全类名
    // logPointCut()代表切点名称
    @Pointcut("@annotation(Annotation.MyLog)")
    public void logPointCut(){};

    // 3. 环绕通知
    @Around("logPointCut()")
    public void logAround(ProceedingJoinPoint joinPoint){
        // 获取方法名称
        String methodName = joinPoint.getSignature().getName();
        // 获取入参
        Object[] param = joinPoint.getArgs();

        StringBuilder sb = new StringBuilder();
        for(Object o : param){
            sb.append(o + "; ");
        }
        System.out.println("进入[" + methodName + "]方法,参数为:" + sb.toString());

        // 继续执行方法
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(methodName + "方法执行结束");

    }

    @Override
    public int getOrder() {
        return 0;
    }
}
