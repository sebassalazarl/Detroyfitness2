// Generated by view binder compiler. Do not edit!
package com.example.detroyfitness2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public final class Questionario3Binding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button BEntrenamiento;

  @NonNull
  public final Button BNutricion;

  @NonNull
  public final Button BPerfil;

  @NonNull
  public final Button BSiguiente;

  @NonNull
  public final RadioGroup ComidasDiarias;

  @NonNull
  public final TextView NombreUsuarioView;

  @NonNull
  public final ImageView botonEntrenoImg;

  @NonNull
  public final ImageView botonnutricionImg;

  @NonNull
  public final ImageView botonperfilImg;

  @NonNull
  public final ImageButton flechaAtrasQuestionario3;

  @NonNull
  public final ImageView fotoPerfil;

  @NonNull
  public final RelativeLayout header;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final ImageView imageView6;

  @NonNull
  public final RelativeLayout main;

  @NonNull
  public final RadioButton p1R1;

  @NonNull
  public final RadioButton p1R2;

  @NonNull
  public final RadioButton p1R3;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final RelativeLayout toolbar;

  private Questionario3Binding(@NonNull ConstraintLayout rootView, @NonNull Button BEntrenamiento,
      @NonNull Button BNutricion, @NonNull Button BPerfil, @NonNull Button BSiguiente,
      @NonNull RadioGroup ComidasDiarias, @NonNull TextView NombreUsuarioView,
      @NonNull ImageView botonEntrenoImg, @NonNull ImageView botonnutricionImg,
      @NonNull ImageView botonperfilImg, @NonNull ImageButton flechaAtrasQuestionario3,
      @NonNull ImageView fotoPerfil, @NonNull RelativeLayout header, @NonNull ImageView imageView,
      @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView6,
      @NonNull RelativeLayout main, @NonNull RadioButton p1R1, @NonNull RadioButton p1R2,
      @NonNull RadioButton p1R3, @NonNull TextView textView, @NonNull TextView textView2,
      @NonNull TextView textView3, @NonNull TextView textView4, @NonNull RelativeLayout toolbar) {
    this.rootView = rootView;
    this.BEntrenamiento = BEntrenamiento;
    this.BNutricion = BNutricion;
    this.BPerfil = BPerfil;
    this.BSiguiente = BSiguiente;
    this.ComidasDiarias = ComidasDiarias;
    this.NombreUsuarioView = NombreUsuarioView;
    this.botonEntrenoImg = botonEntrenoImg;
    this.botonnutricionImg = botonnutricionImg;
    this.botonperfilImg = botonperfilImg;
    this.flechaAtrasQuestionario3 = flechaAtrasQuestionario3;
    this.fotoPerfil = fotoPerfil;
    this.header = header;
    this.imageView = imageView;
    this.imageView2 = imageView2;
    this.imageView3 = imageView3;
    this.imageView6 = imageView6;
    this.main = main;
    this.p1R1 = p1R1;
    this.p1R2 = p1R2;
    this.p1R3 = p1R3;
    this.textView = textView;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static Questionario3Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static Questionario3Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.questionario3, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static Questionario3Binding bind(@NonNull View rootView) {
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

      id = R.id.B_siguiente;
      Button BSiguiente = ViewBindings.findChildViewById(rootView, id);
      if (BSiguiente == null) {
        break missingId;
      }

      id = R.id.Comidas_diarias;
      RadioGroup ComidasDiarias = ViewBindings.findChildViewById(rootView, id);
      if (ComidasDiarias == null) {
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

      id = R.id.flecha_atras_questionario3;
      ImageButton flechaAtrasQuestionario3 = ViewBindings.findChildViewById(rootView, id);
      if (flechaAtrasQuestionario3 == null) {
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

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = ViewBindings.findChildViewById(rootView, id);
      if (imageView2 == null) {
        break missingId;
      }

      id = R.id.imageView3;
      ImageView imageView3 = ViewBindings.findChildViewById(rootView, id);
      if (imageView3 == null) {
        break missingId;
      }

      id = R.id.imageView6;
      ImageView imageView6 = ViewBindings.findChildViewById(rootView, id);
      if (imageView6 == null) {
        break missingId;
      }

      id = R.id.main;
      RelativeLayout main = ViewBindings.findChildViewById(rootView, id);
      if (main == null) {
        break missingId;
      }

      id = R.id.p1_r1;
      RadioButton p1R1 = ViewBindings.findChildViewById(rootView, id);
      if (p1R1 == null) {
        break missingId;
      }

      id = R.id.p1_r2;
      RadioButton p1R2 = ViewBindings.findChildViewById(rootView, id);
      if (p1R2 == null) {
        break missingId;
      }

      id = R.id.p1_r3;
      RadioButton p1R3 = ViewBindings.findChildViewById(rootView, id);
      if (p1R3 == null) {
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

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.toolbar;
      RelativeLayout toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new Questionario3Binding((ConstraintLayout) rootView, BEntrenamiento, BNutricion,
          BPerfil, BSiguiente, ComidasDiarias, NombreUsuarioView, botonEntrenoImg,
          botonnutricionImg, botonperfilImg, flechaAtrasQuestionario3, fotoPerfil, header,
          imageView, imageView2, imageView3, imageView6, main, p1R1, p1R2, p1R3, textView,
          textView2, textView3, textView4, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}