package cn.liu.util.aop.aspect;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;

import cn.liu.constant.AppConstant;
import cn.liu.mapper.system.LogMapper;
import cn.liu.po.User;
import cn.liu.po.system.Log;
import cn.liu.util.aop.annotation.OperationLogDetail;

@Aspect
@Component
public class LogAspect {
	@Autowired LogMapper logMapper;
	@Pointcut("@annotation(cn.liu.util.aop.annotation.OperationLogDetail)")
	public void operationLog() {
	}
	
	@Around("operationLog()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;
		long time = System.currentTimeMillis();
		try {
			result = joinPoint.proceed();
			time = System.currentTimeMillis() - time;
		}catch(Exception e) {
			
		}finally {
			try {
				addOperationLog(joinPoint,result,time,null);
			}catch(Exception e) {
				addOperationLog(joinPoint,result,time,e.getMessage());
			}
			
		}
		return result;
	}
	private void addOperationLog(JoinPoint joinPoint, Object res, long time,String err) {
		/*HttpSession session = request.getSession();
		User user = (User) session.getAttribute(AppConstant.SESSION_USER);*/
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
		        .getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(AppConstant.SESSION_USER);
		if(user == null) {
			return;
		}
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Log log = new Log();
		log.setArgs(JSON.toJSONString(joinPoint.getArgs()));
		log.setMethod(signature.getDeclaringTypeName() + "." + signature.getName());
		log.setReturnValue(JSON.toJSONString(res));
		log.setRunTime((int)time);
		log.setUserId(user.getId());
		OperationLogDetail annotation = signature.getMethod().getAnnotation(OperationLogDetail.class);
		if(annotation != null) {
			log.setOperationType(annotation.operationType().getValue());
			if(annotation.detail() != null && err == null) {
				log.setOperationDescribe(annotation.detail());
			}else {
				log.setOperationDescribe(err);
			}
		}
		logMapper.insert(log);
	}
	
	@Before("operationLog()")
    public void doBeforeAdvice(JoinPoint joinPoint){
        //System.out.println("进入方法前执行.....");

    }
	/**
     * 处理完请求，返回内容
     * @param ret
     */
    @AfterReturning(returning = "ret", pointcut = "operationLog()")
    public void doAfterReturning(Object ret) {
        System.out.println("方法的返回值 : " + ret);
    }
    /**
     * 后置异常通知
     */
    @AfterThrowing("operationLog()")
    public void throwss(JoinPoint jp){
        //System.out.println("方法异常时执行.....");
    }
    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     */
    @After("operationLog()")
    public void after(JoinPoint jp){
        //System.out.println("方法最后执行.....");
    }
}
