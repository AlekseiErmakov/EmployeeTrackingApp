package com.tracking.repository;

import com.tracking.model.employee.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class PostRepositoryImpl implements PostRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public PostRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Post post) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(post);
    }

    @Override
    public void deleteById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Post load = currentSession.byId(Post.class).load(id);
        currentSession.delete(load);
    }

    @Override
    public Post findById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Post post = currentSession.get(Post.class, id);
        return post;
    }

    @Override
    public List<Post> findAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = currentSession.getCriteriaBuilder();
        CriteriaQuery<Post> cq = cb.createQuery(Post.class);
        Root<Post> from = cq.from(Post.class);
        cq.select(from);
        Query<Post> query = currentSession.createQuery(cq);
        return query.getResultList();
    }
}
