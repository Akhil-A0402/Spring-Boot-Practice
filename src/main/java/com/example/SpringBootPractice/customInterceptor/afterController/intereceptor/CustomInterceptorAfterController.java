@Component
@Aspect
public class CustomInterceptorAfterController {

    @Around("@annotation()")
    public void invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before intereception");

        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
        if(method.isAnnotationPresent(CustomAnnotation.class)) {
            CustomAnnotation custAnno = method.getAnnoation(CustomAnnotation.class);
            System.out.println("Annotation class:" + custAnno.name());
        }

        joinPoint.proceed();
        System.out.println("After intereception");
    
    }
}