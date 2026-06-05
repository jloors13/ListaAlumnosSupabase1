package com.example.listaalumnossupabase

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

val supabase = createSupabaseClient(
    supabaseUrl = "https://etqkgtjrtipijhftlitb.supabase.co",
    supabaseKey = "sb_publishablexxxxxx"
) {
    install(Postgrest)
}