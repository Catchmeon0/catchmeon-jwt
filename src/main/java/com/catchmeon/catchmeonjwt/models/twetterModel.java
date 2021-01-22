package com.catchmeon.catchmeonjwt.models;

import java.util.ArrayList;

public class twetterModel {
        private String created_at;
        private float id;
        private String id_str;
        private String text;
        private boolean truncated;
        Entities EntitiesObject;
        Extended_entities Extended_entitiesObject;
        private String source;
        private String in_reply_to_status_id = null;
        private String in_reply_to_status_id_str = null;
        private String in_reply_to_user_id = null;
        private String in_reply_to_user_id_str = null;
        private String in_reply_to_screen_name = null;
        User UserObject;
        private String geo = null;
        private String coordinates = null;
        private String place = null;
        private String contributors = null;
        private boolean is_quote_status;
        private float quoted_status_id;
        private String quoted_status_id_str;
        Quoted_status Quoted_statusObject;
        private float retweet_count;
        private float favorite_count;
        private boolean favorited;
        private boolean retweeted;
        private boolean possibly_sensitive;
        private boolean possibly_sensitive_appealable;
        private String lang;


        // Getter Methods

        public String getCreated_at() {
            return created_at;
        }

        public float getId() {
            return id;
        }

        public String getId_str() {
            return id_str;
        }

        public String getText() {
            return text;
        }

        public boolean getTruncated() {
            return truncated;
        }

        public Entities getEntities() {
            return EntitiesObject;
        }

        public Extended_entities getExtended_entities() {
            return Extended_entitiesObject;
        }

        public String getSource() {
            return source;
        }

        public String getIn_reply_to_status_id() {
            return in_reply_to_status_id;
        }

        public String getIn_reply_to_status_id_str() {
            return in_reply_to_status_id_str;
        }

        public String getIn_reply_to_user_id() {
            return in_reply_to_user_id;
        }

        public String getIn_reply_to_user_id_str() {
            return in_reply_to_user_id_str;
        }

        public String getIn_reply_to_screen_name() {
            return in_reply_to_screen_name;
        }

        public User getUser() {
            return UserObject;
        }

        public String getGeo() {
            return geo;
        }

        public String getCoordinates() {
            return coordinates;
        }

        public String getPlace() {
            return place;
        }

        public String getContributors() {
            return contributors;
        }

        public boolean getIs_quote_status() {
            return is_quote_status;
        }

        public float getQuoted_status_id() {
            return quoted_status_id;
        }

        public String getQuoted_status_id_str() {
            return quoted_status_id_str;
        }

        public Quoted_status getQuoted_status() {
            return Quoted_statusObject;
        }

        public float getRetweet_count() {
            return retweet_count;
        }

        public float getFavorite_count() {
            return favorite_count;
        }

        public boolean getFavorited() {
            return favorited;
        }

        public boolean getRetweeted() {
            return retweeted;
        }

        public boolean getPossibly_sensitive() {
            return possibly_sensitive;
        }

        public boolean getPossibly_sensitive_appealable() {
            return possibly_sensitive_appealable;
        }

        public String getLang() {
            return lang;
        }

        // Setter Methods

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public void setId(float id) {
            this.id = id;
        }

        public void setId_str(String id_str) {
            this.id_str = id_str;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void setTruncated(boolean truncated) {
            this.truncated = truncated;
        }

        public void setEntities(Entities entitiesObject) {
            this.EntitiesObject = entitiesObject;
        }

        public void setExtended_entities(Extended_entities extended_entitiesObject) {
            this.Extended_entitiesObject = extended_entitiesObject;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public void setIn_reply_to_status_id(String in_reply_to_status_id) {
            this.in_reply_to_status_id = in_reply_to_status_id;
        }

        public void setIn_reply_to_status_id_str(String in_reply_to_status_id_str) {
            this.in_reply_to_status_id_str = in_reply_to_status_id_str;
        }

        public void setIn_reply_to_user_id(String in_reply_to_user_id) {
            this.in_reply_to_user_id = in_reply_to_user_id;
        }

        public void setIn_reply_to_user_id_str(String in_reply_to_user_id_str) {
            this.in_reply_to_user_id_str = in_reply_to_user_id_str;
        }

        public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
            this.in_reply_to_screen_name = in_reply_to_screen_name;
        }

        public void setUser(User userObject) {
            this.UserObject = userObject;
        }

        public void setGeo(String geo) {
            this.geo = geo;
        }

        public void setCoordinates(String coordinates) {
            this.coordinates = coordinates;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public void setContributors(String contributors) {
            this.contributors = contributors;
        }

        public void setIs_quote_status(boolean is_quote_status) {
            this.is_quote_status = is_quote_status;
        }

        public void setQuoted_status_id(float quoted_status_id) {
            this.quoted_status_id = quoted_status_id;
        }

        public void setQuoted_status_id_str(String quoted_status_id_str) {
            this.quoted_status_id_str = quoted_status_id_str;
        }

        public void setQuoted_status(Quoted_status quoted_statusObject) {
            this.Quoted_statusObject = quoted_statusObject;
        }

        public void setRetweet_count(float retweet_count) {
            this.retweet_count = retweet_count;
        }

        public void setFavorite_count(float favorite_count) {
            this.favorite_count = favorite_count;
        }

        public void setFavorited(boolean favorited) {
            this.favorited = favorited;
        }

        public void setRetweeted(boolean retweeted) {
            this.retweeted = retweeted;
        }

        public void setPossibly_sensitive(boolean possibly_sensitive) {
            this.possibly_sensitive = possibly_sensitive;
        }

        public void setPossibly_sensitive_appealable(boolean possibly_sensitive_appealable) {
            this.possibly_sensitive_appealable = possibly_sensitive_appealable;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }
    }
    class Quoted_status {
        private String created_at;
        private float id;
        private String id_str;
        private String text;
        private boolean truncated;
        Entities EntitiesObject;
        private String source;
        private String in_reply_to_status_id = null;
        private String in_reply_to_status_id_str = null;
        private String in_reply_to_user_id = null;
        private String in_reply_to_user_id_str = null;
        private String in_reply_to_screen_name = null;
        User UserObject;
        private String geo = null;
        private String coordinates = null;
        private String place = null;
        private String contributors = null;
        private boolean is_quote_status;
        private float retweet_count;
        private float favorite_count;
        private boolean favorited;
        private boolean retweeted;
        private boolean possibly_sensitive;
        private boolean possibly_sensitive_appealable;
        private String lang;


        // Getter Methods

        public String getCreated_at() {
            return created_at;
        }

        public float getId() {
            return id;
        }

        public String getId_str() {
            return id_str;
        }

        public String getText() {
            return text;
        }

        public boolean getTruncated() {
            return truncated;
        }

        public Entities getEntities() {
            return EntitiesObject;
        }

        public String getSource() {
            return source;
        }

        public String getIn_reply_to_status_id() {
            return in_reply_to_status_id;
        }

        public String getIn_reply_to_status_id_str() {
            return in_reply_to_status_id_str;
        }

        public String getIn_reply_to_user_id() {
            return in_reply_to_user_id;
        }

        public String getIn_reply_to_user_id_str() {
            return in_reply_to_user_id_str;
        }

        public String getIn_reply_to_screen_name() {
            return in_reply_to_screen_name;
        }

        public User getUser() {
            return UserObject;
        }

        public String getGeo() {
            return geo;
        }

        public String getCoordinates() {
            return coordinates;
        }

        public String getPlace() {
            return place;
        }

        public String getContributors() {
            return contributors;
        }

        public boolean getIs_quote_status() {
            return is_quote_status;
        }

        public float getRetweet_count() {
            return retweet_count;
        }

        public float getFavorite_count() {
            return favorite_count;
        }

        public boolean getFavorited() {
            return favorited;
        }

        public boolean getRetweeted() {
            return retweeted;
        }

        public boolean getPossibly_sensitive() {
            return possibly_sensitive;
        }

        public boolean getPossibly_sensitive_appealable() {
            return possibly_sensitive_appealable;
        }

        public String getLang() {
            return lang;
        }

        // Setter Methods

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public void setId(float id) {
            this.id = id;
        }

        public void setId_str(String id_str) {
            this.id_str = id_str;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void setTruncated(boolean truncated) {
            this.truncated = truncated;
        }

        public void setEntities(Entities entitiesObject) {
            this.EntitiesObject = entitiesObject;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public void setIn_reply_to_status_id(String in_reply_to_status_id) {
            this.in_reply_to_status_id = in_reply_to_status_id;
        }

        public void setIn_reply_to_status_id_str(String in_reply_to_status_id_str) {
            this.in_reply_to_status_id_str = in_reply_to_status_id_str;
        }

        public void setIn_reply_to_user_id(String in_reply_to_user_id) {
            this.in_reply_to_user_id = in_reply_to_user_id;
        }

        public void setIn_reply_to_user_id_str(String in_reply_to_user_id_str) {
            this.in_reply_to_user_id_str = in_reply_to_user_id_str;
        }

        public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
            this.in_reply_to_screen_name = in_reply_to_screen_name;
        }

        public void setUser(User userObject) {
            this.UserObject = userObject;
        }

        public void setGeo(String geo) {
            this.geo = geo;
        }

        public void setCoordinates(String coordinates) {
            this.coordinates = coordinates;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public void setContributors(String contributors) {
            this.contributors = contributors;
        }

        public void setIs_quote_status(boolean is_quote_status) {
            this.is_quote_status = is_quote_status;
        }

        public void setRetweet_count(float retweet_count) {
            this.retweet_count = retweet_count;
        }

        public void setFavorite_count(float favorite_count) {
            this.favorite_count = favorite_count;
        }

        public void setFavorited(boolean favorited) {
            this.favorited = favorited;
        }

        public void setRetweeted(boolean retweeted) {
            this.retweeted = retweeted;
        }

        public void setPossibly_sensitive(boolean possibly_sensitive) {
            this.possibly_sensitive = possibly_sensitive;
        }

        public void setPossibly_sensitive_appealable(boolean possibly_sensitive_appealable) {
            this.possibly_sensitive_appealable = possibly_sensitive_appealable;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }
    }
    class User {
        private float id;
        private String id_str;
        private String name;
        private String screen_name;
        private String location;
        private String description;
        private String url;
        Entities EntitiesObject;
        private boolean _protected;
        private float followers_count;
        private float friends_count;
        private float listed_count;
        private String created_at;
        private float favourites_count;
        private String utc_offset = null;
        private String time_zone = null;
        private boolean geo_enabled;
        private boolean verified;
        private float statuses_count;
        private String lang = null;
        private boolean contributors_enabled;
        private boolean is_translator;
        private boolean is_translation_enabled;
        private String profile_background_color;
        private String profile_background_image_url = null;
        private String profile_background_image_url_https = null;
        private boolean profile_background_tile;
        private String profile_image_url;
        private String profile_image_url_https;
        private String profile_banner_url;
        private String profile_link_color;
        private String profile_sidebar_border_color;
        private String profile_sidebar_fill_color;
        private String profile_text_color;
        private boolean profile_use_background_image;
        private boolean has_extended_profile;
        private boolean default_profile;
        private boolean default_profile_image;
        private String following = null;
        private String follow_request_sent = null;
        private String notifications = null;
        private String translator_type;


        // Getter Methods

        public float getId() {
            return id;
        }

        public String getId_str() {
            return id_str;
        }

        public String getName() {
            return name;
        }

        public String getScreen_name() {
            return screen_name;
        }

        public String getLocation() {
            return location;
        }

        public String getDescription() {
            return description;
        }

        public String getUrl() {
            return url;
        }

        public Entities getEntities() {
            return EntitiesObject;
        }

        public boolean getProtected() {
            return _protected;
        }

        public float getFollowers_count() {
            return followers_count;
        }

        public float getFriends_count() {
            return friends_count;
        }

        public float getListed_count() {
            return listed_count;
        }

        public String getCreated_at() {
            return created_at;
        }

        public float getFavourites_count() {
            return favourites_count;
        }

        public String getUtc_offset() {
            return utc_offset;
        }

        public String getTime_zone() {
            return time_zone;
        }

        public boolean getGeo_enabled() {
            return geo_enabled;
        }

        public boolean getVerified() {
            return verified;
        }

        public float getStatuses_count() {
            return statuses_count;
        }

        public String getLang() {
            return lang;
        }

        public boolean getContributors_enabled() {
            return contributors_enabled;
        }

        public boolean getIs_translator() {
            return is_translator;
        }

        public boolean getIs_translation_enabled() {
            return is_translation_enabled;
        }

        public String getProfile_background_color() {
            return profile_background_color;
        }

        public String getProfile_background_image_url() {
            return profile_background_image_url;
        }

        public String getProfile_background_image_url_https() {
            return profile_background_image_url_https;
        }

        public boolean getProfile_background_tile() {
            return profile_background_tile;
        }

        public String getProfile_image_url() {
            return profile_image_url;
        }

        public String getProfile_image_url_https() {
            return profile_image_url_https;
        }

        public String getProfile_banner_url() {
            return profile_banner_url;
        }

        public String getProfile_link_color() {
            return profile_link_color;
        }

        public String getProfile_sidebar_border_color() {
            return profile_sidebar_border_color;
        }

        public String getProfile_sidebar_fill_color() {
            return profile_sidebar_fill_color;
        }

        public String getProfile_text_color() {
            return profile_text_color;
        }

        public boolean getProfile_use_background_image() {
            return profile_use_background_image;
        }

        public boolean getHas_extended_profile() {
            return has_extended_profile;
        }

        public boolean getDefault_profile() {
            return default_profile;
        }

        public boolean getDefault_profile_image() {
            return default_profile_image;
        }

        public String getFollowing() {
            return following;
        }

        public String getFollow_request_sent() {
            return follow_request_sent;
        }

        public String getNotifications() {
            return notifications;
        }

        public String getTranslator_type() {
            return translator_type;
        }

        // Setter Methods

        public void setId(float id) {
            this.id = id;
        }

        public void setId_str(String id_str) {
            this.id_str = id_str;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setScreen_name(String screen_name) {
            this.screen_name = screen_name;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setEntities(Entities entitiesObject) {
            this.EntitiesObject = entitiesObject;
        }

        public void setProtected(boolean _protected) {
            this._protected = _protected;
        }

        public void setFollowers_count(float followers_count) {
            this.followers_count = followers_count;
        }

        public void setFriends_count(float friends_count) {
            this.friends_count = friends_count;
        }

        public void setListed_count(float listed_count) {
            this.listed_count = listed_count;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public void setFavourites_count(float favourites_count) {
            this.favourites_count = favourites_count;
        }

        public void setUtc_offset(String utc_offset) {
            this.utc_offset = utc_offset;
        }

        public void setTime_zone(String time_zone) {
            this.time_zone = time_zone;
        }

        public void setGeo_enabled(boolean geo_enabled) {
            this.geo_enabled = geo_enabled;
        }

        public void setVerified(boolean verified) {
            this.verified = verified;
        }

        public void setStatuses_count(float statuses_count) {
            this.statuses_count = statuses_count;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        public void setContributors_enabled(boolean contributors_enabled) {
            this.contributors_enabled = contributors_enabled;
        }

        public void setIs_translator(boolean is_translator) {
            this.is_translator = is_translator;
        }

        public void setIs_translation_enabled(boolean is_translation_enabled) {
            this.is_translation_enabled = is_translation_enabled;
        }

        public void setProfile_background_color(String profile_background_color) {
            this.profile_background_color = profile_background_color;
        }

        public void setProfile_background_image_url(String profile_background_image_url) {
            this.profile_background_image_url = profile_background_image_url;
        }

        public void setProfile_background_image_url_https(String profile_background_image_url_https) {
            this.profile_background_image_url_https = profile_background_image_url_https;
        }

        public void setProfile_background_tile(boolean profile_background_tile) {
            this.profile_background_tile = profile_background_tile;
        }

        public void setProfile_image_url(String profile_image_url) {
            this.profile_image_url = profile_image_url;
        }

        public void setProfile_image_url_https(String profile_image_url_https) {
            this.profile_image_url_https = profile_image_url_https;
        }

        public void setProfile_banner_url(String profile_banner_url) {
            this.profile_banner_url = profile_banner_url;
        }

        public void setProfile_link_color(String profile_link_color) {
            this.profile_link_color = profile_link_color;
        }

        public void setProfile_sidebar_border_color(String profile_sidebar_border_color) {
            this.profile_sidebar_border_color = profile_sidebar_border_color;
        }

        public void setProfile_sidebar_fill_color(String profile_sidebar_fill_color) {
            this.profile_sidebar_fill_color = profile_sidebar_fill_color;
        }

        public void setProfile_text_color(String profile_text_color) {
            this.profile_text_color = profile_text_color;
        }

        public void setProfile_use_background_image(boolean profile_use_background_image) {
            this.profile_use_background_image = profile_use_background_image;
        }

        public void setHas_extended_profile(boolean has_extended_profile) {
            this.has_extended_profile = has_extended_profile;
        }

        public void setDefault_profile(boolean default_profile) {
            this.default_profile = default_profile;
        }

        public void setDefault_profile_image(boolean default_profile_image) {
            this.default_profile_image = default_profile_image;
        }

        public void setFollowing(String following) {
            this.following = following;
        }

        public void setFollow_request_sent(String follow_request_sent) {
            this.follow_request_sent = follow_request_sent;
        }

        public void setNotifications(String notifications) {
            this.notifications = notifications;
        }

        public void setTranslator_type(String translator_type) {
            this.translator_type = translator_type;
        }
    }
    class Entities {
        Url UrlObject;
        Description DescriptionObject;


        // Getter Methods

        public Url getUrl() {
            return UrlObject;
        }

        public Description getDescription() {
            return DescriptionObject;
        }

        // Setter Methods

        public void setUrl(Url urlObject) {
            this.UrlObject = urlObject;
        }

        public void setDescription(Description descriptionObject) {
            this.DescriptionObject = descriptionObject;
        }
    }
    class Description {
        ArrayList< Object > urls = new ArrayList < Object > ();


        // Getter Methods



        // Setter Methods


    }
    class Url {
        ArrayList < Object > urls = new ArrayList < Object > ();


        // Getter Methods



        // Setter Methods


    }
    class Extended_entities {
        ArrayList < Object > media = new ArrayList < Object > ();


        // Getter Methods



        // Setter Methods


    }


