export default [
  {
    path: "*",
    meta: {
      public: true
    },
    redirect: {
      path: "/404"
    }
  },
  {
    path: "/404",
    meta: {
      public: true
    },
    name: "NotFound",
    component: () =>
        import(
            /* webpackChunkName: "routes" */
            `@/views/NotFound.vue`
            )
  },

  {
    path: "/403",
    meta: {
      public: true
    },
    name: "AccessDenied",
    component: () =>
        import(
            /* webpackChunkName: "routes" */
            `@/views/Deny.vue`
            )
  },
  {
    path: "/500",
    meta: {
      public: true
    },
    name: "ServerError",
    component: () =>
        import(
            /* webpackChunkName: "routes" */
            `@/views/Error.vue`
            )
  },
  {
    path: "/login",
    meta: {
      public: true
    },
    name: "Login",
    component: () =>
        import(
            /* webpackChunkName: "routes" */
            `@/views/Login.vue`
            )
  },
  {
    path: "/filtre",
    meta: { breadcrumb: true },
    name: "filtre",
    component: () =>
        import(
            /* webpackChunkName: "routes" */
            `@/views/Login.vue`
            )
  },
  {
    path: "/",
    meta: {},
    name: "Root",
    redirect: {
      name: "Dashboard"
    }
  },
  {
    path: "/dashboard",
    meta: { breadcrumb: true },
    name: "Dashboard",
    component: () =>
        import(
            /* webpackChunkName: "routes" */
            `@/views/Dashboard.vue`
            )
  },
  {
    path: "/VisualEA",
    meta: { breadcrumb: true },
    name: "VisualEA",
    component: () =>
        import(
            /* webpackChunkName: "routes" */
            `@/views/VisualEA.vue`
            )
  },
  {
    path: "/addstateofart",
    meta: { breadcrumb: true },
    name: "addstateofart",
    component: () =>
        import(
            /* webpackChunkName: "routes" */
            `@/views/addstateofart.vue`
            )
  },
  {
    path: "/graphe3",
    meta: { breadcrumb: true },
    name: "graphe3",
    component: () =>
        import(
            /* webpackChunkName: "routes" */
            `@/views/graphe3.vue`
            )
  },
  {
    path: "/etatdelart",
    meta: { breadcrumb: true },
    name: "etatdelart",
    component: () =>
        import(
            /* webpackChunkName: "routes" */
            `@/views/etatdelart.vue`
            )
  },

  {
    path: "/editemail",
    meta: {},
    name: "editemail",
    component: () =>
        import(
            /* webpackChunkName: "routes" */
            `@/views/editemail.vue`
            )
  },

  {
    path: "/editprofil",
    meta: { breadcrumb: true },
    name: "editprofil",
    component: () =>
        import(
            /* webpackChunkName: "routes" */
            `@/views/editprofil.vue`
            )
  },

  {
    path: "/editpassword",
    meta: { breadcrumb: true },
    name: "editpassword",
    component: () =>
        import(
            /* webpackChunkName: "routes" */
            `@/views/editpassword.vue`
            )
  },
  {
    path: "/addstateofart",
    meta: { breadcrumb: true },
    name: "addstateofart",
    component: () =>
        import(
            /* webpackChunkName: "routes" */
            `@/views/addstateofart.vue`
            )
  },

  {
    path: "/StaticSearchHistory",
    meta: { breadcrumb: true },
    name: "StaticSearchHistory",
    component: () =>
        import(
            /* webpackChunkName: "routes" */
            `@/views/StaticSearchHistory.vue`
            )
  },

  {
    path: "/contactus",
    meta: { breadcrumb: true },
    name: "contactus",
    component: () =>
        import(
            /* webpackChunkName: "routes" */
            `@/views/contactus.vue`
            )
  },
  {
    path: "/personalpage",
    meta: { breadcrumb: true },
    name: "personalpage",
    component: () =>
        import(
            /* webpackChunkName: "routes" */
            `@/views/personalpage.vue`
            )
  },
  {
    path: "/result_page",

    meta: { breadcrumb: true },
    name: "result_page",
    component: () =>
        import(
            /* webpackChunkName: "routes" */
            `@/views/result_page.vue`
            )
  },
  {
    path: "/advancedSearch",
    meta: { breadcrumb: true },
    name: "AdvancedSearch",
    component: () =>
        import(
            /* webpackChunkName: "routes" */
            `@/views/AdvancedSearch.vue`
            )
  }
];