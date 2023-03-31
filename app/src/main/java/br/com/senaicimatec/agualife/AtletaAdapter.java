package br.com.senaicimatec.agualife;
import java.util.ArrayList;
import android.widget.*;
import java.util.List;
import android.content.Context;
import android.view.*;
import android.view.ViewGroup;

public class AtletaAdapter extends ArrayAdapter<Atleta> {
    private Context mContext;
    private int mResource;
    private List<Atleta> mAtletas;

    public AtletaAdapter(Context context, int resource, List<Atleta> atletas) {
        super(context, resource, atletas);
        mContext = context;
        mResource = resource;
        mAtletas = atletas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
        }

        TextView nomeTextView = convertView.findViewById(R.id.nome_text_view);
        TextView idadeTextView = convertView.findViewById(R.id.idade_text_view);
        TextView pesoTextView = convertView.findViewById(R.id.peso_text_view);

        Atleta atleta = mAtletas.get(position);

        nomeTextView.setText(atleta.getNome());
        idadeTextView.setText("Idade: " + atleta.getIdade());
        pesoTextView.setText("Peso: " + atleta.getPeso() + " kg");

        return convertView;
    }
}