# Android_RecyclerView_ModelClass
Getting Data in RecyclerView From Model Class and showing on to the UI

This topic is a part of [My Complete Andorid Course](https://github.com/ananddasani/Android_Apps)

# Code

**1. Make a Model Class**
```
public class ModelClass {

    private int image;
    private String name;
    private String message;
    private String time;

    public ModelClass(int image, String name, String message, String time) {
        this.image = image;
        this.name = name;
        this.message = message;
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
```

**2. Make Custom Adapter for RecyclerView**
### Adapter.java
```
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<ModelClass> userList;

    public Adapter(List<ModelClass> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        int imageResource = userList.get(position).getImage();
        String nameResource = userList.get(position).getName();
        String messageResource = userList.get(position).getMessage();
        String timeResource = userList.get(position).getTime();

        holder.setData(imageResource, nameResource, messageResource, timeResource);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView name;
        private TextView message;
        private TextView time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.textName);
            message = itemView.findViewById(R.id.textMessage);
            time = itemView.findViewById(R.id.textTime);
        }

        public void setData(int imageResource, String nameResource, String messageResource, String timeResource) {
            image.setImageResource(imageResource);
            name.setText(nameResource);
            message.setText(messageResource);
            time.setText(timeResource);
        }
    }
}
```

**3. Make my_layout.xml (Custom Layout File)**
### my_layout.xml
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <androidx.cardview.widget.CardView
        android:id="@+id/cardView"
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:layout_marginStart="16dp"
        android:layout_marginTop="16dp"
        android:layout_marginBottom="16dp"
        app:cardCornerRadius="60dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <ImageView
            android:id="@+id/imageView"
            android:layout_width="60dp"
            android:layout_height="60dp"
            app:srcCompat="@drawable/u2" />
    </androidx.cardview.widget.CardView>

    <TextView
        android:id="@+id/textName"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="32dp"
        android:layout_marginTop="16dp"
        android:text="Anand"
        android:textColor="@color/black"
        android:textSize="20sp"
        app:layout_constraintStart_toEndOf="@+id/cardView"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/textTime"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="32dp"
        android:layout_marginEnd="16dp"
        android:text="10:30 AM"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/textMessage"
        android:layout_width="150dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="32dp"
        android:layout_marginTop="8dp"
        android:text="How are you ?"
        app:layout_constraintStart_toEndOf="@+id/cardView"
        app:layout_constraintTop_toBottomOf="@+id/textName" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

**4. Do Backend Work**
#### MainActivity.java
```
RecyclerView recyclerView;
LinearLayoutManager linearLayoutManager;
List<ModelClass> userList = new ArrayList<>();
Adapter adapter;

initData();
initRecyclerView();

     public void initRecyclerView() {

        recyclerView = findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Adapter(userList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void initData() {

        userList.add(new ModelClass(R.drawable.u1, "Anand", "How are you ?", "10:45 AM"));
        userList.add(new ModelClass(R.drawable.u2, "Ajay", "Are you free ?", "11:45 AM"));
        userList.add(new ModelClass(R.drawable.u3, "Meet", "Good Morning", "12:45 AM"));
        userList.add(new ModelClass(R.drawable.u4, "Ria", "How are you ?", "1:45 AM"));
        userList.add(new ModelClass(R.drawable.u1, "Jay", "Let's have a meet ?", "2:45 PM"));
        userList.add(new ModelClass(R.drawable.u2, "Sia", "Har Har Mahadev", "5:45 PM"));
        userList.add(new ModelClass(R.drawable.u3, "Rose", "What's the time", "7:45 PM"));
        userList.add(new ModelClass(R.drawable.u4, "Joise", "How are you ?", "10:45 PM"));
    }
```

# App Highlight

![Recycler View Custom Adapter Code](https://user-images.githubusercontent.com/74413402/192095460-cac82e7b-fe00-484f-bf22-987b350d69df.png)
![RecyclerView ModelClass App](https://user-images.githubusercontent.com/74413402/192095463-754857d4-33e5-46b5-8643-871cf09337a6.png)
![RecyclerView ModelClass Code](https://user-images.githubusercontent.com/74413402/192095467-fe14dc83-94d8-4966-aaa9-c7e9944dc710.png)

