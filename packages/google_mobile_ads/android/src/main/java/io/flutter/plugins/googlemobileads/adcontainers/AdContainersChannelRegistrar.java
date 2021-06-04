package io.flutter.plugins.googlemobileads.adcontainers;

import android.content.Context;

import java.util.List;

import github.penguin.reference.reference.TypeChannelMessenger;

public class AdContainersChannelRegistrar extends AdContainersChannelLibrary.$ChannelRegistrar {
  public AdContainersChannelRegistrar(AdContainersChannelLibrary.$LibraryImplementations implementations) {
    super(implementations);
  }

  public static class AdContainersLibraryImplementations extends AdContainersChannelLibrary.$LibraryImplementations {
    public final Context context;

    public AdContainersLibraryImplementations(TypeChannelMessenger messenger, Context context) {
      super(messenger);
      this.context = context;
    }

    @Override
    public AdRequestHandler getHandlerAdRequest() {
      return new AdRequestHandler();
    }

    @Override
    public AdManagerAdRequestHandler getHandlerAdManagerAdRequest() {
      return new AdManagerAdRequestHandler();
    }

    @Override
    public AdSizeHandler getHandlerAdSize() {
      return new AdSizeHandler(this);
    }

    @Override
    public BannerAdListenerHandler getHandlerBannerAdListener() {
      return new BannerAdListenerHandler(this);
    }

    @Override
    public BannerAdHandler getHandlerBannerAd() {
      return new BannerAdHandler(this);
    }

    @Override
    public AdManagerBannerAdListenerHandler getHandlerAdManagerBannerAdListener() {
      return new AdManagerBannerAdListenerHandler(this);
    }

    @Override
    public AdManagerBannerAdHandler getHandlerAdManagerBannerAd() {
      return new AdManagerBannerAdHandler(this);
    }
  }

  public static class AdRequestHandler extends AdContainersChannelLibrary.$AdRequestHandler {
    @Override
    public AdRequestProxy $$create(TypeChannelMessenger messenger) {
      return new AdRequestProxy();
    }
  }

  public static class AdManagerAdRequestHandler extends AdContainersChannelLibrary.$AdManagerAdRequestHandler {
    @Override
    public AdManagerAdRequestProxy $$create(TypeChannelMessenger messenger) {
      return new AdManagerAdRequestProxy();
    }
  }

  public static class AdSizeHandler extends AdContainersChannelLibrary.$AdSizeHandler {
    public final AdContainersLibraryImplementations implementations;

    public AdSizeHandler(AdContainersLibraryImplementations implementations) {
      this.implementations = implementations;
    }

    @Override
    public AdSizeProxy $$create(TypeChannelMessenger messenger, Integer width, Integer height, String constant) {
      return new AdSizeProxy(width, height, constant);
    }

    @Override
    public AdSizeProxy $getLandscapeAnchoredAdaptiveBannerAdSize(TypeChannelMessenger messenger, Integer width) {
      return AdSizeProxy.getLandscapeAnchoredAdaptiveBannerAdSize(width, implementations);
    }

    @Override
    public AdSizeProxy $getPortraitAnchoredAdaptiveBannerAdSize(TypeChannelMessenger messenger, Integer width) {
      return AdSizeProxy.getPortraitAnchoredAdaptiveBannerAdSize(width, implementations);
    }
  }

  public static class BannerAdListenerHandler extends AdContainersChannelLibrary.$BannerAdListenerHandler {
    public final AdContainersLibraryImplementations implementations;

    public BannerAdListenerHandler(AdContainersLibraryImplementations implementations) {
      this.implementations = implementations;
    }

    @Override
    public BannerAdListenerProxy $$create(TypeChannelMessenger messenger) throws Exception {
      return new BannerAdListenerProxy(implementations);
    }
  }

  public static class BannerAdHandler extends AdContainersChannelLibrary.$BannerAdHandler {
    public final AdContainersLibraryImplementations implementations;

    public BannerAdHandler(AdContainersLibraryImplementations implementations) {
      this.implementations = implementations;
    }

    @Override
    public BannerAdProxy $$create(TypeChannelMessenger messenger, AdContainersChannelLibrary.$AdSize size, String adUnitId, AdContainersChannelLibrary.$BannerAdListener listener, AdContainersChannelLibrary.$AdRequest request) {
      return new BannerAdProxy((AdSizeProxy) size, adUnitId, (BannerAdListenerProxy) listener, (AdRequestProxy) request, implementations);
    }
  }
  
  public static class AdManagerBannerAdListenerHandler extends AdContainersChannelLibrary.$AdManagerBannerAdListenerHandler {
    public final AdContainersLibraryImplementations implementations;

    public AdManagerBannerAdListenerHandler(AdContainersLibraryImplementations implementations) {
      this.implementations = implementations;
    }
    
    @Override
    public AdManagerBannerAdListenerProxy $$create(TypeChannelMessenger messenger) {
      return new AdManagerBannerAdListenerProxy(implementations);
    }
  }

  public static class AdManagerBannerAdHandler extends AdContainersChannelLibrary.$AdManagerBannerAdHandler {
    public final AdContainersLibraryImplementations implementations;

    public AdManagerBannerAdHandler(AdContainersLibraryImplementations implementations) {
      this.implementations = implementations;
    }

    @Override
    public AdManagerBannerAdProxy $$create(TypeChannelMessenger messenger, List<AdContainersChannelLibrary.$AdSize> sizes, String adUnitId, AdContainersChannelLibrary.$AdManagerBannerAdListener listener, AdContainersChannelLibrary.$AdManagerAdRequest request) throws Exception {
      return new AdManagerBannerAdProxy(sizes, adUnitId, (AdManagerBannerAdListenerProxy) listener, (AdManagerAdRequestProxy) request, implementations);
    }
  }
}
