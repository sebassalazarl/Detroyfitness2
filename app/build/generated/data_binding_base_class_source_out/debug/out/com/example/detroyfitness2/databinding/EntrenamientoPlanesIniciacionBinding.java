// Generated by view binder compiler. Do not edit!
package com.example.detroyfitness2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
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

public final class EntrenamientoPlanesIniciacionBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button BEntrenamiento;

  @NonNull
  public final ImageButton BFlechaAtrasEntrenamiento;

  @NonNull
  public final Button BNutricion;

  @NonNull
  public final Button BPerfil;

  @NonNull
  public final Button BRutinaIniciacionDia1;

  @NonNull
  public final Button BRutinaIniciacionDia2;

  @NonNull
  public final Button BRutinaIniciacionDia3;

  @NonNull
  public final Button BRutinaIniciacionDia4;

  @NonNull
  public final Button BRutinaIniciacionDia5;

  @NonNull
  public final ImageView botonEntrenoImg;

  @NonNull
  public final ImageView botonnutricionImg;

  @NonNull
  public final ImageView botonperfilImg;

  @NonNull
  public final RelativeLayout header;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textoSobrecarga3;

  @NonNull
  public final TextView textonutricion;

  @NonNull
  public final RelativeLayout toolbar;

  private EntrenamientoPlanesIniciacionBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button BEntrenamiento, @NonNull ImageButton BFlechaAtrasEntrenamiento,
      @NonNull Button BNutricion, @NonNull Button BPerfil, @NonNull Button BRutinaIniciacionDia1,
      @NonNull Button BRutinaIniciacionDia2, @NonNull Button BRutinaIniciacionDia3,
      @NonNull Button BRutinaIniciacionDia4, @NonNull Button BRutinaIniciacionDia5,
      @NonNull ImageView botonEntrenoImg, @NonNull ImageView botonnutricionImg,
      @NonNull ImageView botonperfilImg, @NonNull RelativeLayout header, @NonNull TextView textView,
      @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textoSobrecarga3,
      @NonNull TextView textonutricion, @NonNull RelativeLayout toolbar) {
    this.rootView = rootView;
    this.BEntrenamiento = BEntrenamiento;
    this.BFlechaAtrasEntrenamiento = BFlechaAtrasEntrenamiento;
    this.BNutricion = BNutricion;
    this.BPerfil = BPerfil;
    this.BRutinaIniciacionDia1 = BRutinaIniciacionDia1;
    this.BRutinaIniciacionDia2 = BRutinaIniciacionDia2;
    this.BRutinaIniciacionDia3 = BRutinaIniciacionDia3;
    this.BRutinaIniciacionDia4 = BRutinaIniciacionDia4;
    this.BRutinaIniciacionDia5 = BRutinaIniciacionDia5;
    this.botonEntrenoImg = botonEntrenoImg;
    this.botonnutricionImg = botonnutricionImg;
    this.botonperfilImg = botonperfilImg;
    this.header = header;
    this.textView = textView;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.textoSobrecarga3 = textoSobrecarga3;
    this.textonutricion = textonutricion;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static EntrenamientoPlanesIniciacionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static EntrenamientoPlanesIniciacionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.entrenamiento_planes_iniciacion, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static EntrenamientoPlanesIniciacionBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.B_entrenamiento;
      Button BEntrenamiento = ViewBindings.findChildViewById(rootView, id);
      if (BEntrenamiento == null) {
        break missingId;
      }

      id = R.id.B_flecha_atras_entrenamiento;
      ImageButton BFlechaAtrasEntrenamiento = ViewBindings.findChildViewById(rootView, id);
      if (BFlechaAtrasEntrenamiento == null) {
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

      id = R.id.B_rutinaIniciacion_dia1;
      Button BRutinaIniciacionDia1 = ViewBindings.findChildViewById(rootView, id);
      if (BRutinaIniciacionDia1 == null) {
        break missingId;
      }

      id = R.id.B_rutinaIniciacion_dia2;
      Button BRutinaIniciacionDia2 = ViewBindings.findChildViewById(rootView, id);
      if (BRutinaIniciacionDia2 == null) {
        break missingId;
      }

      id = R.id.B_rutinaIniciacion_dia3;
      Button BRutinaIniciacionDia3 = ViewBindings.findChildViewById(rootView, id);
      if (BRutinaIniciacionDia3 == null) {
        break missingId;
      }

      id = R.id.B_rutinaIniciacion_dia4;
      Button BRutinaIniciacionDia4 = ViewBindings.findChildViewById(rootView, id);
      if (BRutinaIniciacionDia4 == null) {
        break missingId;
      }

      id = R.id.B_rutinaIniciacion_dia5;
      Button BRutinaIniciacionDia5 = ViewBindings.findChildViewById(rootView, id);
      if (BRutinaIniciacionDia5 == null) {
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

      id = R.id.header;
      RelativeLayout header = ViewBindings.findChildViewById(rootView, id);
      if (header == null) {
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

      id = R.id.texto_sobrecarga3;
      TextView textoSobrecarga3 = ViewBindings.findChildViewById(rootView, id);
      if (textoSobrecarga3 == null) {
        break missingId;
      }

      id = R.id.textonutricion;
      TextView textonutricion = ViewBindings.findChildViewById(rootView, id);
      if (textonutricion == null) {
        break missingId;
      }

      id = R.id.toolbar;
      RelativeLayout toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new EntrenamientoPlanesIniciacionBinding((ConstraintLayout) rootView, BEntrenamiento,
          BFlechaAtrasEntrenamiento, BNutricion, BPerfil, BRutinaIniciacionDia1,
          BRutinaIniciacionDia2, BRutinaIniciacionDia3, BRutinaIniciacionDia4,
          BRutinaIniciacionDia5, botonEntrenoImg, botonnutricionImg, botonperfilImg, header,
          textView, textView2, textView3, textoSobrecarga3, textonutricion, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
