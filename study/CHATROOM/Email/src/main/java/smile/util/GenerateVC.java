package smile.util;

import java.util.Random;

/**
 * @author ：smile丶
 * @date ：Created in 19-3-16 下午1:35
 * @description：生成验证码
 * @modified By：
 * @version: $version$
 */
public class GenerateVC {

    public static String generateVC(){
        char[] le =new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        String vc = "";
        Random random = new Random();
        for (int i = 0; i<6 ; i++){
            if (random.nextInt()%2==0){
                vc+=random.nextInt(10);
            }else {
                vc+=le[random.nextInt(26)];
            }
        }
        return vc;
    }
    public static void main(String[] args) {
        System.out.println(GenerateVC.generateVC());

    }

}
