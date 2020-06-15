package com.example.myclouds.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.myclouds.R;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "nuvols";
    private static final int DATABASE_VERSION = 2;

    private final String sqlTableNuvols = "CREATE TABLE nuvols (codi INTEGER PRIMARY KEY, nom TEXT, abrev TEXT, altura TEXT, precipitacio TEXT, descripcio TEXT,  imatge TEXT, icono TEXT)";
    private final String n1 = "INSERT INTO nuvols (codi, nom, abrev, altura, precipitacio, descripcio, imatge, icono) VALUES (0, 'Cirrus', 'Ci', 'Por encima de los 5 kilometros', 'No', 'Tipo de nube separada, formando filamentos blancos de aspecto fibroso o sedoso. Formadas por cristales de hielo más pesados, que precipitan, dándole su particular aspecto. \n \n Una forma de virga (la nube parece que cae pero se evapora antes de alcanzar el suelo) indican la diferencia en el movimiento del aire entre la parte superior del cirrus y el aire de debajo. Cuando se disponen aislados son síntoma de buen tiempo, pero si avanzan organizados aumentando progresivamente, indican un cambio inminente del tiempo. \n \n Los cirros contribuyen a atrapar el calor emitido por la Tierra hacia el espacio, en consecuencia, no está bien determinado si el efecto de los cirros es de calentamiento o de enfriamiento de la tierra.\n\n', 'cirrus_img', 'ci');";
    private final String n2 = "INSERT INTO nuvols (codi, nom, abrev, altura, precipitacio, descripcio, imatge, icono) VALUES (1, 'Cirrocumulus', 'Cc', 'Entre 6 y 12 kilometros', 'No', 'Nube formada por pequeñas y delgadas áreas blancas, las cuales están compuestas por granos u ondas muy pequeñas. Se forman a partir de cirros o cirrostratos cuando son calentadas desde abajo. Este proceso de calentamiento hace que el aire se eleve y se meta dentro de la nube. Razón por la cual el cirrocúmulo se asocia casi siempre con cirros y cirroestratos. \n \n Los cirrocúmulos y los altocúmulos parecen idénticos, sin embargo, los cirrocúmulos son más altos y no producen sombra. Como todas las nubes de los niveles altos, los cirrocúmulos están compuestos por cristales de hielo, que al evaporarse pueden dar lugar a la aparición de espacios entre las nubes. Estas nubes son síntomas de buen tiempo, salvo si aumentan considerablemente, no suelen indicar cambio de tiempo.\n\n', 'cirrocumulus_img', 'cc');";
    private final String n3 = "INSERT INTO nuvols (codi, nom, abrev, altura, precipitacio, descripcio, imatge, icono) VALUES (2, 'Cirrostratus', 'Cs', 'Entre 6 y 12 kilometros', 'No, aunque suelen anunciarlas', 'Tipo de nubes altas caracterizadas por estar compuestas de cristales de hielo y frecuentemente por la producción del fenómeno óptico, llamado halo. Suelen aparecer como velos blanquecinos, transparentes y fibrosos, a veces cubriendo gran parte o la totalidad del cielo. \n \n Estas nubes suelen suceder a los Cirros y preludian la llegada de mal tiempo por tormentas o frentes cálidos. Son signo de precipitación moderada en las siguientes 12 horas.\n\n', 'cirrostratus_img', 'cs');";
    private final String n4 = "INSERT INTO nuvols (codi, nom, abrev, altura, precipitacio, descripcio, imatge, icono) VALUES (3, 'Altostratus', 'As', 'Entre 2 y 5 kilometros', 'Sí', 'Clase de nube caracterizada por una gran lámina de color grisáceo uniforme, más claras en color que los nimbostratus y más oscuras que los cirroestratos, siendo potencialmente peligrosas para la aeronavegación. En la sección más fina de la nube, se puede ver el sol débilmente como un disco.\n \n Una forma de diferenciar altrostratos y cirrostratos, a parte del halo caracteristico de las nubes cirriformes, es ver si hay sombras en el suelo, en caso negativo, son altoestratos, ya que las cirrostratos son suficientemente trasnparentes para dejar que pase el sol. \n \n Estas nubes son formadas por delante de tormentas, que pueden producir precipitaciones generalizadas y relativamente continuadas, con descenso de la temperatura.\n\n', 'altostratus_img', 'as');";
    private final String n5 = "INSERT INTO nuvols (codi, nom, abrev, altura, precipitacio, descripcio, imatge, icono) VALUES (4, 'Altocumulus', 'Ac', 'Entre 2 y 6 kilometros', 'No, aunque suelen anunciarlas', 'Caracterizada en estratos, capas, o parches con masas en ondas o bandas, de color grisáceas. Generalmente, la nube tiene una parte más oscura que la otra, lo que las ayuda a diferenciarse de los cirrocúmulos. \n \n Los altocúmulos frecuentemente preceden a un frente frío, y con la presencia de mañanas calurosas y húmedas de verano, señalan el desarrollo de nubes de tormenta más tarde en el día. Cuando sus parches se disponen en \"ovejas\" se trata de altocumulus castellanus o castellatus, frecuentemente asociadas a señales de tormenta avanzado el día, debido a que son signo de inestabilidad y convección en los niveles medios de la troposfera. En la zona donde hubiese imponentes cúmulos pueden convertirse en cumulonimbus, una de las tres nubes de advertencia registradas a menudo por la industria de la aviación. \n \n Una forma de altocúmulos, los altocumulus lenticularis u ondas de montaña, suelen reportarse como OVNI.\n\n', 'altocumulus_img', 'ac');";
    private final String n6 = "INSERT INTO nuvols (codi, nom, abrev, altura, precipitacio, descripcio, imatge, icono) VALUES (5, 'Stratus', 'St', 'Menos de 2 kilometros', 'Sí', 'Manto de nubes chatas, sin estructura definida y de baja altitud, siendo de color gris negruzco hasta blanquecinas, y presentando manchas de diferente opacidad y variaciones de color. \n \n Estas nubes son parecidas a una niebla que no llega hasta el suelo, dando en ocasiones, precipitación, transformándose, en caso de estar bajas en altitud, en neblina, niebla, o en llovizna. Las formaciones de estratos vienen acompañadas de precipitación con nimboestratos. \n \n Durante otoño e invierno los estratos pueden permanecer en el cielo durante toda la jornada, mientras que, durante la primavera y principios del verano aparecen durante la madrugada dispersándose durante el día, indicando buen tiempo.\n\n', 'stratus_img', 'st');";
    private final String n7 = "INSERT INTO nuvols (codi, nom, abrev, altura, precipitacio, descripcio, imatge, icono) VALUES (6, 'Stratocumulus', 'Sc', 'Por debajo de 2 kilometros', 'No', 'Nubes caracterizadas por ser grandes masas oscuras, redondeadas, generalmente en grupos, cuyo elementos individuales son más grandes que los de altocumulus, pudiéndose observar el cielo entre ellos. \n \n Generalmente los estratocúmulos no aportan precipitación, o solamente lloviznas o neviscas. Sin embargo, estas nubes suelen anticipar peor tiempo, indicando tormentas a futuro, o al menos un frente tormentoso.\n \n Similares en apariencia a los altocumulos, suelen confundirse. Para distinguirlos, se compara el tamaño de las masas individuales o rollos, apuntando el índice en la dirección de la nube, en caso de ser como el tamaño del pulgar, es un altocúmulo, si es como toda la mano, es un estratocumulo.\n\n', 'stratocumulus_img', 'sc');";
    private final String n8 = "INSERT INTO nuvols (codi, nom, abrev, altura, precipitacio, descripcio, imatge, icono) VALUES (7, 'Nimbostratus', 'Ns', 'Menos de 3 kilometros', 'Sí', 'Nube oscura caracterizada por capas uniformes, generalmente de color gris oscuro, que resultan del engrosamiento de los altoestratos. Los nimbostratos bloquean completamente la luz solar, disminuyendo la visibilidad. \n \n En comparación con los estratos, altoestratos y cirroestratos, los nimboestratos siempre dan precipitaciones, que suelen ser continuas y no muy intensas.\n\n', 'nimbostratus_img', 'ns');";
    private final String n9 = "INSERT INTO nuvols (codi, nom, abrev, altura, precipitacio, descripcio, imatge, icono) VALUES (8, 'Cumulus', 'Cu', 'Por debajo de 2 kilometros', 'Depende, cumulus congestus sí.', 'Tipo de nube con un considerable desarrollo vertical, bordes claramente definidos y un aspecto a menudo parecido al \"algodón\", pudiendo aparecer a pocos cientos de metros del suelo en días húmedos. \n \n Los cúmulos que presentan un ligero crecimiento vertical, llamados cumulus humilis, están asociados al buen tiempo, por lo contrario, si crecen hasta tener una cúpula, se les llama cumulus congestus, siendo nubes de carácter imponente (precursores de otros tipos de nubes, como el cumulonimbo), formadas por lo general de manera aislada, aunque en ocasiones, si se unen varias de ellas, llegan a producir precipitaciones en forma de chubascos.\n\n', 'cumulus_img', 'cu');";
    private final String n10 = "INSERT INTO nuvols (codi, nom, abrev, altura, precipitacio, descripcio, imatge, icono) VALUES (9, 'Cumulonimbus', 'Cb', 'Por debajo de 2 kilometros y hasta 15-20 kilometros', 'Lluvias intensas y tormentas electricas', 'Nubes de gran desarrollo vertical, internamente formadas por una columna de aire cálido y húmedo que se eleva en forma de espiral rotatoria. Para su formación se necesita la concurrencia de tres factores: mucha humedad en el ambiente, una masa inestable de aire caliente y una fuente de energía para subir rápidamente esa masa.\n \n Su base puede encontrarse a no más de 600 metros del suelo, mientras que la cima puede ser superior a los 10 km de altitud. Cuando están plenamente desarrolladas adoptan una forma de yunque con la punta hacia atrás con respecto a la dirección del desplazamiento de la tormenta, es decir, a sotavento. La cima de cumulonimbus suele ser lisa o con estrías, y casi siempre aplastada. Por debajo de la base, muy oscura, aparecen nubes bajas, rasgadas y lluvias. En el desarrollo de las nubes, la cumulonimbus se forman luego de las cumulus congestus.\n \n Estas nubes suelen producir precipitaciones intensas y tormentas eléctricas, especialmente cuando ya están plenamente desarrolladas. Se pueden formar aisladamente, en grupos, o a lo largo de un frente frío en una línea de inestabilidad.\n\n', 'cumulonimbus_img', 'cb');";

    private Context sqlcontext;

    public SQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.sqlcontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS nuvols");
        db.execSQL(sqlTableNuvols);
        db.execSQL(n1); db.execSQL(n2);
        db.execSQL(n3); db.execSQL(n4);
        db.execSQL(n5); db.execSQL(n6);
        db.execSQL(n7); db.execSQL(n8);
        db.execSQL(n9); db.execSQL(n10);
        //insertDB(db, Locale.getDefault().getLanguage());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS nuvols");
        db.execSQL(sqlTableNuvols);
        db.execSQL(n1); db.execSQL(n2);
        db.execSQL(n3); db.execSQL(n4);
        db.execSQL(n5); db.execSQL(n6);
        db.execSQL(n7); db.execSQL(n8);
        db.execSQL(n9); db.execSQL(n10);
        //insertDB(db, Locale.getDefault().getLanguage());
    }

    private void insertDB(SQLiteDatabase db, String lang){
        BufferedReader reader;
        String line = "";
        int id = 0;
        switch(lang){
            //case "es":{ id = R.raw.bd_es;    }break;
            default:{   id = R.raw.bd_es;   }break;
        }
        InputStream in = sqlcontext.getResources().openRawResource(id);
        reader = new BufferedReader(new InputStreamReader(in));

        try {
            while (((line = reader.readLine()) != null)){
                db.execSQL(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
