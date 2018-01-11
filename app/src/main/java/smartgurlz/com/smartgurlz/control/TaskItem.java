package smartgurlz.com.smartgurlz.control;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Ali on 11/01/2018.
 */

// or @ThrowOnExtraProperties
@IgnoreExtraProperties
public class TaskItem {
    private String name = "";
    private String uid;

    public TaskItem(String name, String email) {
        // empty for Firebase
    }

    public TaskItem(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }

    // implement for easy comparison
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof TaskItem) {
            TaskItem item = ((TaskItem)obj);
            if (item.getUid() == null) {
                return false;
            }
            return item.getUid().contentEquals(getUid());
        }

        return super.equals(obj);
    }
}