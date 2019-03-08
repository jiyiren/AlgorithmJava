package basic.comp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/4/24 下午8:12
 * @Description
 */

public class Main {

    public static void main(String[] args) {
        Comparator<User> comparator = (a,b) ->{
          return a.height - b.height;
        };

        List<User> mList=  new ArrayList<>();
        mList.add(new User(8));
        mList.add(new User(7));
        mList.add(new User(2));
        mList.add(new User(3));
        mList.add(new User(10));
        Collections.sort(mList,comparator);

        for (User u:mList) {
            System.out.println(u.height);
        }
    }
}
