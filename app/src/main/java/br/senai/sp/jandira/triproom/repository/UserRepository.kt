package br.senai.sp.jandira.triproom.repository

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Email
import br.senai.sp.jandira.triproom.dao.TripDb
import br.senai.sp.jandira.triproom.model.User

class UserRepository(context: Context) {

    //Variável que representa nosso banco de dados
    private val db = TripDb.getDataBase(context)

    //Responsavel por inserir um novo usuario no banco
    fun save(user: User): Long {
        return db.userDao().save(user)
    }

    //Responsavel por encontrar um usuario por e-mail
    fun findUserByEmail(email: String): User {
        return db.userDao().findUserByEmail(email)
    }

    //Responsavel pela autentificacao do usuario
    fun authenticate(email: String, password: String): User {
        return db.userDao().authenticate(email, password)
    }

}