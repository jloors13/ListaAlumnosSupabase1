package com.example.listaalumnossupabase

import android.util.Log
import com.example.listaalumnossupabase.BuildConfig
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

val supabase = createSupabaseClient(
    supabaseUrl = BuildConfig.SUPABASE_URL,
    supabaseKey = BuildConfig.SUPABASE_KEY
) {
    install(Postgrest)
}

fun verificarCredenciales() {
    Log.d("SUPABASE_URL", BuildConfig.SUPABASE_URL)
    Log.d("SUPABASE_KEY", BuildConfig.SUPABASE_KEY)
}