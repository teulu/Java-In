package jvm.ThisEscape;

import java.util.EventListener;

/**
 * Created by liur on 17-5-7.
 */
public class ThisSafe {
    public final int id;
    public final String name;
    private final EventListener listener;

    private ThisSafe() {
        id = 1;
        listener = new EventListener(){
            public void onEvent(Object obj) {
                System.out.println("id: "+ThisSafe.this.id);
                System.out.println("name: "+ThisSafe.this.name);
            }
        };
        name = "flysqrlboy";
    }

    public static ThisSafe getInstance(EventSource<EventListener> source) {
        ThisSafe safe = new ThisSafe();
        source.registerListener(safe.listener);
        return safe;
    }

}
