package br.ufpe.cin.if1001.rss;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

public class PreferenciasActivity extends Activity {
    public static String URL_KEY = "rssFeed";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);
    }

    public static class RssPreferenceFragment extends PreferenceFragment {
        private SharedPreferences.OnSharedPreferenceChangeListener mListener;
        private Preference preference;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Carrega preferences a partir de um XML
            addPreferencesFromResource(R.xml.preferencias);

            // pega a Preference especifica do username
            preference = getPreferenceManager().findPreference(PreferenciasActivity.URL_KEY);

            // Define um listener para atualizar descricao ao modificar preferences
            mListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
                @Override
                public void onSharedPreferenceChanged(
                        SharedPreferences sharedPreferences, String key) {
                    preference.setSummary(sharedPreferences.getString(
                            PreferenciasActivity.URL_KEY, "Nada ainda"));
                }
            };

            // Pega objeto SharedPreferences gerenciado pelo PreferenceManager para este Fragmento
            SharedPreferences prefs = getPreferenceManager()
                    .getSharedPreferences();

            // Registra listener no objeto SharedPreferences
            prefs.registerOnSharedPreferenceChangeListener(mListener);

            // Invoca callback manualmente para exibir preferencia atual
            mListener.onSharedPreferenceChanged(prefs, PreferenciasActivity.URL_KEY);
        }
    }

    /**
     * Seta SharedPreferences
     * @param key
     * @param value
     * @param context
     */
    public static void setDefaults(String key, String value, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * Obtem SharedPreferences
     * @param key
     * @param context
     * @return
     */
    public static String getDefaults(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }
}