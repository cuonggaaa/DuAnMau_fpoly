package cuongnvph24076.fpoly.QuanlyvsThongke.Thongketop10;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import cuongnvph24076.fpoly.LOPADAPTER.S_Adapter;
import cuongnvph24076.fpoly.LOPADAPTER.Top10_Adapter;
import cuongnvph24076.fpoly.LOPDAO.SachDao;
import cuongnvph24076.fpoly.LOPDAO.Top10Dao;
import cuongnvph24076.fpoly.LOPPRODUCT.Sach;
import cuongnvph24076.fpoly.LOPPRODUCT.Top;
import cuongnvph24076.fpoly.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Thongketo10Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Thongketo10Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Thongketo10Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Thongketo10Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Thongketo10Fragment newInstance(String param1, String param2) {
        Thongketo10Fragment fragment = new Thongketo10Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thongketo10, container, false);
    }

    private RecyclerView rcv;
    private List<Sach> saches;
    private S_Adapter adapter;
    private SachDao sachDao;

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);

        saches = sachDao.SachTop10();
        adapter = new S_Adapter(requireContext(), saches, new SachDao(requireContext()));
        rcv.setAdapter(adapter);
    }

    private void init(View view) {
        rcv = view.findViewById(R.id.rcl_sach);
        saches = new ArrayList<>();
        sachDao = new SachDao(requireContext());
        adapter = new S_Adapter(requireContext(), saches, new SachDao(requireContext()));
    }
}