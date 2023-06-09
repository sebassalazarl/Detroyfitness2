// Generated by view binder compiler. Do not edit!
package com.example.detroyfitness2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.detroyfitness2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class PantallaPrincipalBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button BEntrenamiento;

  @NonNull
  public final Button BNutricion;

  @NonNull
  public final Button BPerfil;

  @NonNull
  public final TextView NombreUsuarioView;

  @NonNull
  public final ImageView botonEntrenoImg;

  @NonNull
  public final ImageView botonnutricionImg;

  @NonNull
  public final ImageView botonperfilImg;

  @NonNull
  public final ImageView fotoPerfil;

  @NonNull
  public final RelativeLayout header;

  @NonNull
  public final RelativeLayout main;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final RelativeLayout toolbar;

  private PantallaPrincipalBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button BEntrenamiento, @NonNull Button BNutricion, @NonNull Button BPerfil,
      @NonNull TextView NombreUsuarioView, @NonNull ImageView botonEntrenoImg,
      @NonNull ImageView botonnutricionImg, @NonNull ImageView botonperfilImg,
      @NonNull ImageView fotoPerfil, @NonNull RelativeLayout header, @NonNull RelativeLayout main,
      @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3,
      @NonNull RelativeLayout toolbar) {
    this.rootView = rootView;
    this.BEntrenamiento = BEntrenamiento;
    this.BNutricion = BNutricion;
    this.BPerfil = BPerfil;
    this.NombreUsuarioView = NombreUsuarioView;
    this.botonEntrenoImg = botonEntrenoImg;
    this.botonnutricionImg = botonnutricionImg;
    this.botonperfilImg = botonperfilImg;
    this.fotoPerfil = fotoPerfil;
    this.header = header;
    this.main = main;
    this.textView = textView;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static PantallaPrincipalBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PantallaPrincipalBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.pantalla_principal, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PantallaPrincipalBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.B_entrenamiento;
      Button BEntrenamiento = ViewBindings.findChildViewById(rootView, id);
      if (BEntrenamiento == null) {
        break missingId;
      }

      id = R.id.B_nutricion;
      Button BNutricion = ViewBindings.findChildViewById(rootView, id);
      if (BNutricion == null) {
        break missingId;
      }

      id = R.id.B_perfil;
      Button BPerfil = ViewBindings.findChildViewById(rootView, id);
      if (BPerfil == null) {
        break missingId;
      }

      id = R.id.NombreUsuarioView;
      TextView NombreUsuarioView = ViewBindings.findChildViewById(rootView, id);
      if (NombreUsuarioView == null) {
        break missingId;
      }

      id = R.id.botonEntreno_img;
      ImageView botonEntrenoImg = ViewBindings.findChildViewById(rootView, id);
      if (botonEntrenoImg == null) {
        break missingId;
      }

      id = R.id.botonnutricion_img;
      ImageView botonnutricionImg = ViewBindings.findChildViewById(rootView, id);
      if (botonnutricionImg == null) {
        break missingId;
      }

      id = R.id.botonperfil_img;
      ImageView botonperfilImg = ViewBindings.findChildViewById(rootView, id);
      if (botonperfilImg == null) {
        break missingId;
      }

      id = R.id.foto_perfil;
      ImageView fotoPerfil = ViewBindings.findChildViewById(rootView, id);
      if (fotoPerfil == null) {
        break missingId;
      }

      id = R.id.header;
      RelativeLayout header = ViewBindings.findChildViewById(rootView, id);
      if (header == null) {
        break missingId;
      }

      id = R.id.main;
      RelativeLayout main = ViewBindings.findChildViewById(rootView, id);
      if (main == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.toolbar;
      RelativeLayout toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new PantallaPrincipalBinding((ConstraintLayout) rootView, BEntrenamiento, BNutricion,
          BPerfil, NombreUsuarioView, botonEntrenoImg, botonnutricionImg, botonperfilImg,
          fotoPerfil, header, main, textView, textView2, textView3, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
