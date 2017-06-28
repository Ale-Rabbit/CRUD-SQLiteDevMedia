package alexandra.example.com.crud_sqlitedevmedia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alexandra on 27/06/17.
 *
 * SQLiteDatabase: Classe que contém os métodos de manipulação dos dados no banco;
 *
 * SQLiteOpenHelper: Classe responsável pela criação do banco e também responsável pelo versionamento do mesmo.
 */

public class CriaBanco extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "banco.db";
    protected static final String TABELA = "livros";
    protected static final String ID = "_id";
    protected static final String TITULO = "titulo";
    protected static final String AUTOR = "autor";
    protected static final String EDITORA = "editora";
    private static final int VERSAO = 1;

//   O construtor que passará para a super classe as informações do local e versão do banco.
    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
//    É chamado quando a aplicação cria o banco de dados pela primeira vez.
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + TITULO + " text,"
                + AUTOR + " text,"
                + EDITORA + " text"
                +")";
        db.execSQL(sql);
    }


    @Override
//   É o método responsável por atualizar o banco de dados com alguma informação estrutural que tenha sido alterada.
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABELA);
        onCreate(db);

    }


}
