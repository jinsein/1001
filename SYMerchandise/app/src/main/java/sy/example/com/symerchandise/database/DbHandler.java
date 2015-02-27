package sy.example.com.symerchandise.database;

/**
 * Created by JJIN on 15-01-15.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DbHandler extends SQLiteOpenHelper {

    private static final String TAG = DbHandler.class.getSimpleName();

    private static final String DATABASE_NAME = "sy.db";
    private static final String TABLE_NAME_PRODUCT = "product";

    private static final String PRODUCT_COL_id = "id";
    private static final String PRODUCT_COL_name = "name";
    private static final String PRODUCT_COL_stock = "stock";
    private static final String PRODUCT_COL_price = "price";


    private static final String TABLE_NAME_TRANSACTION = "transaction";

    private static final String TRANSACTION_COL_id = "id";
    private static final String TRANSACTION_COL_product_id = "product_id";
    private static final String TRANSACTION_COL_quantity = "quantity";
    private static final String TRANSACTION_COL_price = "total_price";
    private static final String TRANSACTION_COL_type_id = "type_id";


    private static final String TABLE_NAME_TYPE = "type";

    private static final String TYPE_COL_id = "id";
    private static final String TYPE_COL_type = "type";


    public DbHandler(Context context){
        super(context, DATABASE_NAME, null, 1);

        Log.i(TAG, "Constructor");


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCT_TABLE = "create table " + TABLE_NAME_PRODUCT + "(" +
                PRODUCT_COL_id + "   INTEGER    NOT NULL   PRIMARY KEY , " +
                PRODUCT_COL_name + "   VARCHAR(255)    NOT NULL ," +
                PRODUCT_COL_stock + " INTEGER NOT NULL," +
                PRODUCT_COL_price + " DOUBLE NOT NULL );";
        //Log.i(TAG, CREATE_PRODUCT_TABLE);
        db.execSQL(CREATE_PRODUCT_TABLE);
        Log.i(TAG, TABLE_NAME_PRODUCT + " is created");

        /*
        String CREATE_TRANSACTION_TABLE = "create table " + TABLE_NAME_TRANSACTION + "(" +
                TRANSACTION_COL_id + "   INTEGER    NOT NULL   PRIMARY KEY , " +
                TRANSACTION_COL_product_id + "   INTEGER    NOT NULL , " +
                TRANSACTION_COL_quantity + "  INTEGER    NOT NULL ," +
                TRANSACTION_COL_price + " DOUBLE NOT NULL," +
                TRANSACTION_COL_type_id + " INTEGER NOT NULL );";

        Log.i(TAG, CREATE_TRANSACTION_TABLE);

        db.execSQL(CREATE_TRANSACTION_TABLE);
        Log.i(TAG, TABLE_NAME_TRANSACTION + " is created");


        String CREATE_TYPE_TABLE = "create table " + TABLE_NAME_TYPE + "(" +
                TYPE_COL_id + "   INTEGER    NOT NULL   PRIMARY KEY , " +
                TYPE_COL_type + " VARCHAR(255)    NOT NULL);";

        db.execSQL(CREATE_TYPE_TABLE);
        Log.i(TAG, TABLE_NAME_TYPE + " is created");*/

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        onCreate(db);
    }

    public void deleteTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        onCreate(db);
    }

    public void insertProduct(String name, int stock, double price){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PRODUCT_COL_name, name);
        values.put(PRODUCT_COL_stock, stock);
        values.put(PRODUCT_COL_price, price);

        db.insert(TABLE_NAME_PRODUCT, null, values);
        db.close(); // Closing database connection
    }

    public String find(long id, String table_name){

        SQLiteDatabase db = this.getReadableDatabase();

        String command = "select name from " + table_name + " where " + PRODUCT_COL_id + "=" + id + "";
        Cursor cursor = db.rawQuery(command, null);
        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();

            return cursor.getString(0);
        }
        return "";
    }

}

