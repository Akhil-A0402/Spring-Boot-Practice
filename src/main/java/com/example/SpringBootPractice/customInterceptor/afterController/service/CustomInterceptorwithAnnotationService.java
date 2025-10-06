
@Service
public class CustomInterceptorwithAnnotationService {
    @CustomAnnotation
    public void testingMethod() {
        System.out.println("Inside testing Method");
    }
}