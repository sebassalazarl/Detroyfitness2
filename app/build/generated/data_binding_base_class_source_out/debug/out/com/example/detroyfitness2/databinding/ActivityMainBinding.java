// Generated by view binder compiler. Do not edit!
package com.example.detroyfitness2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.detroyfitness2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final Button BLogin;

  @NonNull
  public final Button BRegistrar;

  @NonNull
  public final EditText IntroducePWD;

  @NonNull
  public final EditText IntroduceUsuario;

  @NonNull
  public final ImageView logo;

  @NonNull
  public final Button referencia;

  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final TextView textlogin;

  private ActivityMainBinding(@NonNull CoordinatorLayout rootView, @NonNull Button BLogin,
      @NonNull Button BRegistrar, @NonNull EditText IntroducePWD,
      @NonNull EditText IntroduceUsuario, @NonNull ImageView logo, @NonNull Button referencia,
      @NonNull RelativeLayout relativeLayout, @NonNull TextView textlogin) {
    this.rootView = rootView;
    this.BLogin = BLogin;
    this.BRegistrar = BRegistrar;
    this.IntroducePWD = IntroducePWD;
    this.IntroduceUsuario = IntroduceUsuario;
    this.logo = logo;
    this.referencia = referencia;
    this.relativeLayout = relativeLayout;
    this.textlogin = textlogin;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.B_login;
      Button BLogin = ViewBindings.findChildViewById(rootView, id);
      if (BLogin == null) {
        break missingId;
      }

      id = R.id.B_Registrar;
      Button BRegistrar = ViewBindings.findChildViewById(rootView, id);
      if (BRegistrar == null) {
        break missingId;
      }

      id = R.id.IntroducePWD;
      EditText IntroducePWD = ViewBindings.findChildViewById(rootView, id);
      if (IntroducePWD == null) {
        break missingId;
      }

      id = R.id.IntroduceUsuario;
      EditText IntroduceUsuario = ViewBindings.findChildViewById(rootView, id);
      if (IntroduceUsuario == null) {
        break missingId;
      }

      id = R.id.logo;
      ImageView logo = ViewBindings.findChildViewById(rootView, id);
      if (logo == null) {
        break missingId;
      }

      id = R.id.referencia;
      Button referencia = ViewBindings.findChildViewById(rootView, id);
      if (referencia == null) {
        break missingId;
      }

      id = R.id.relativeLayout;
      RelativeLayout relativeLayout = ViewBindings.findChildViewById(rootView, id);
      if (relativeLayout == null) {
        break missingId;
      }

      id = R.id.textlogin;
      TextView textlogin = ViewBindings.findChildViewById(rootView, id);
      if (textlogin == null) {
        break missingId;
      }

      return new ActivityMainBinding((CoordinatorLayout) rootView, BLogin, BRegistrar, IntroducePWD,
          IntroduceUsuario, logo, referencia, relativeLayout, textlogin);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
