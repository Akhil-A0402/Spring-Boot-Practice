@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {
    int key() default 0;
    String name() default "";
    Class<?> classTypeKey() default String.class;
    MyCustomEnum enumKey() default MyCustomEnum.EnumKey_1;
    String[] stringArrayKey() default {"key1", "key2"};
    int[] intArrayKey() default {1, 1};
}