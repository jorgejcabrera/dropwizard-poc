package com.jjc.infrastructure.user

import com.jjc.core.user.User
import com.jjc.core.user.UserRepository
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import org.hibernate.SessionFactory

class UserHibernateRepository : UserRepository/*,
    AbstractDAO<User>(sessionFactory) */{

    override fun save(user: User): User {
        /*
        val cb: CriteriaBuilder = currentSession().criteriaBuilder
        val getCardAccount: CriteriaQuery<CardAccount> = this.criteriaQuery()
        */
        TODO("Not yet implemented")

    }
}